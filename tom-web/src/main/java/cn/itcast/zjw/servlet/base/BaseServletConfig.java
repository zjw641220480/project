package cn.itcast.zjw.servlet.base;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:BaseServletConfig
 * @Description:
 * @author TOM
 * @Time: 2016年7月6日下午10:19:28
 */
public class BaseServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BaseServletConfig() {
    	System.out.println("该Servlet被创建");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletContext());
		//System.out.println(this.getServletContext());这种方式一直会出现null指针异常
		System.out.println(this);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		super.destroy();
	}
	
	/*
	 * 一个Servlet的整体init-param对应一个ServletConfig;
	 * */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init....");
		/**
		 * 获取Servlet配置
		 */
		System.out.println(config.getInitParameter("p1"));
		System.out.println(config.getInitParameter("p3"));
		String path = config.getInitParameter("p3");
		if (path != null) {
			try{
			// 加载log4j配置文件出现FileNotFoundException,流加载异常的错误;后期需要进行处理
			//	PropertyConfigurator.configure(path);
			}catch(Exception e){
				System.out.println("日志文件加载不成功,日志文件路径为:\t"+path);
			}
		}
		Enumeration<String> enumeration = config.getInitParameterNames();
		System.out.println(enumeration);
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
		//获取ServletContext的两种方式;
		//第一种方式一直会有空指针异常出现;
		//ServletContext servletContext = getServletContext();//这种方式获取ServletContext似乎有些问题;
		ServletContext servletContext = config.getServletContext();
		servletContext.setAttribute("servletContextParam", "servletContextValue");
	}

}
