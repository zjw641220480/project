package cn.itcast.zjw.shiro.config;

import java.util.LinkedHashMap;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.itcast.zjw.shiro.realm.CustomerRealm;

/**
 * 
 * @ClassName: ShiroConfiguration.java
 * @Description:Shiro的相关配置
 * @Time 2017年9月25日
 * @author: Tom
 */
@Configuration
public class ShiroConfiguration {
	/**
	 * 
	 * @Method:shiroFilter
	 * @Description:配置Shiro的过滤器
	 * @Time 2017年9月25日 下午1:53:26
	 * @author: Tom
	 * @param manager
	 * @return
	 */
	@Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        //用户没有认证的时候，就跳转到/user/login方法里面进行认证
        bean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/errorView/403_error.html");
        //配置访问权限
        //尽量取消url拦截配置方法，使用注解授权方式
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/logout", "logout");
        //配置记住我或认证通过可以访问的地址
        filterChainDefinitionMap.put("/index", "user");
        filterChainDefinitionMap.put("/", "user");

        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }
	//配置核心安全事务管理器
    @Bean(name="securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") CustomerRealm authRealm) {
        System.err.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }
    //配置自定义的权限登录器（自定义realm的配置）
    @Bean(name="authRealm")
    public CustomerRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
    	CustomerRealm authRealm = new CustomerRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }
   //配置自定义的密码比较器（凭证匹配器）
    @Bean(name="credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
    	HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
    	hashedCredentialsMatcher.setHashAlgorithmName("md5");
    	hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}
