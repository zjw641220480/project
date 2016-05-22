package org.shiro.identity;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestSingleRealm {
	/**
	 * 使用继承自Realm的SingleRealm;
	 */
	@Test
	public void testShiroDemo(){
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<?> factory = new IniSecurityManagerFactory("classpath:shiro\\identity\\shiro-realm.ini");
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		SecurityManager securityManager =  (SecurityManager) factory.getInstance(); 
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证） 
		//上面三步可以理解为收集身份验证;
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {  
	        //4、登录，即身份验证  
	        subject.login(token);  
	        System.out.println("登录成功");
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	System.out.println("没有登录成功");
	    }  
		subject.logout();
	}
}
