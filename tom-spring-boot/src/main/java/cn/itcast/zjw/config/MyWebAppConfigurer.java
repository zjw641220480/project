package cn.itcast.zjw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.itcast.zjw.interceptor.MyInterceptor1;
import cn.itcast.zjw.interceptor.MyInterceptor2;

/**
 * 
 * @ClassName: MyWebAppConfigurer.java
 * @Description:拦截器相关配置类，在这里注入拦截器的相关类
 * @Time 2017年9月19日
 * @author: Tom
 */
//@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        
        super.addInterceptors(registry);
    }
}
