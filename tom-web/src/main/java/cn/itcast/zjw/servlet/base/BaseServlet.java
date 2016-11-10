package cn.itcast.zjw.servlet.base;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * 注:Servlet是由服务器来启动,一个Servlet在tomcat容器中只有一个实例对象,Servlet是单例模式的;
 * Servlet默认是在第一次被请求的时候创建实例对象;
 */
/**
 * 
 * @ClassName:BaseServlet
 * @Description:Servlet基本简介,
 * @author TOM
 * @Time: 2016年7月6日下午5:38:55
 */
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletConfig getServletConfig() {

		return null;
	}

	/*
	 * Servlet简介,一般没有什么很大作用;
	 */
	public String getServletInfo() {
		System.out.println("Baseservlet.getServletInfo()");
		return null;
	}

	/*
	 * 生命周期方法 它会在Servlet对象创建之后马上执行,并只执行一次;(出生之后)
	 * 虽然Servlet的这个方法可以用来释放连接,关闭流等相关操作,但是,一般我们不这样做;
	 */
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init......");
	}

	/*
	 * 生命周期方法 它会被调用多次 每次处理请求都是在调用这个方法;
	 */
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service......");
	}

	/*
	 * 
	 * 生命周期方法 它会在Servlet被销毁之前调用,并且它只会被调用一次;
	 */
	public void destroy() {
		System.out.println("destroy.....");
	}
}
