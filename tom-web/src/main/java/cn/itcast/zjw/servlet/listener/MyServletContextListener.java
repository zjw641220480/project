package cn.itcast.zjw.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.itcast.zjw.servlet.filter.MyFilter;

/**
 * 
 * <p>Titile:MyServletContextListener</p>
 * <p>Description: ServletContextListener:监听servletContext创建和销毁
 * 		● contextInitialized(ServletContextEvent s)方法用来初始化ServletContext对象。

		● contextDestroyed(ServletContextEvent s)方法在上下文中删除某个属性时调用。

		● attributeAdded(ServletContextAttributeEvent sa)方法在上下文中添加一个新的属性时调用。

		● attributeReplaced(ServletContextAttributeEvent sa)方法在更新属性时调用。

		● attributeRemoved(ServletContextAttributeEvent sa)方法在上下文中删除某个属性时会被调用。
 * </p>
 * @author TOM
 * @date 2017年7月24日 下午4:48:44
 */
public class MyServletContextListener implements ServletContextListener,ServletContextAttributeListener{
	private ServletContext context;
	public void contextInitialized(ServletContextEvent sce) {
		//对ServletContext进行赋值
		this.context = sce.getServletContext();
		System.out.println("ServletContext创建的监听");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext销毁的监听");
	}
	public void attributeAdded(ServletContextAttributeEvent event) {
		context.addFilter("filter", MyFilter.class);
		System.out.println("ServletContext新增的属性名称为:\t"+event.getName());
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		context.removeAttribute("filter");
		System.out.println("ServletContext移除的属性名称为:\t"+event.getName());
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		context.setAttribute("filter", MyFilter.class);
		System.out.println("ServletContext替换的属性名称为:\t"+event.getName());
	}

	

}
