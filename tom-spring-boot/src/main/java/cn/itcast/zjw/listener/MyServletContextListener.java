package cn.itcast.zjw.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @ClassName: MyServletContextListener.java
 * @Description:使用@WebListener注解，实现ServletContextListener接口
 * @Time 2017年9月19日
 * @author: Tom
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContex销毁");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContex销毁");
	}
	
}
