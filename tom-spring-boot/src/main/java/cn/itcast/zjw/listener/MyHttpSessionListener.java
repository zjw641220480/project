package cn.itcast.zjw.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @ClassName: MyHttpSessionListener
 * @Description: Spring Boot中配置web环境中的监听器，使用@WebListener注解进行，也需要在启动类中添加上@ServletComponentScan注解
 * @author: TOM
 * @Time: 2017年9月19日
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session 被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session 被创建");
	}

}
