package cn.itcast.zjw.servlet.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:BaseServletContext
 * @Description:演示ServletContext,其内的值已经在BaseServletConfig中设置过了;使用ServletContext获取资源路径
 * @author TOM
 * @Time: 2016年7月7日下午8:18:50
 */
public class BaseServletContext extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/*
	 * 演示获取ContextParam全局参数 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletContextParamValue = req.getServletContext().getInitParameter("cp1");
		System.out.println("该Servlet获取到的全局配置参数值为\t"+servletContextParamValue);
		System.out.println("在BaseServletConfig设置的ServletContext域变量值为\t"+req.getServletContext().getAttribute("servletContextParam"));
		//使用ServletContext获取资源路径
		ServletContext servletContext = req.getServletContext();
		String path = servletContext.getRealPath("/index.jsp");
		System.out.println(path);
		//三种方式获取log4j日志的绝对路径;
		String log4jPath = servletContext.getRealPath("classpath:log4j.properties");
		log4jPath = servletContext.getRealPath("/log4j.properties");
		log4jPath = servletContext.getRealPath("log4j.properties");
		System.out.println("log4j日志文件绝对路径\t"+log4jPath);
		System.out.println(servletContext.getRealPath("log4j.properties"));
		//使用ServletContext获取资源流对象;
		InputStream input = servletContext.getResourceAsStream("/index.jsp");
//		input = servletContext.getResourceAsStream("log4j.properties");
		System.out.println(input.toString());
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("在BaseServletConfig中设置的ServletContext域变量的值为\t"+config.getServletContext().getAttribute("servletContextParam"));
	}

}
