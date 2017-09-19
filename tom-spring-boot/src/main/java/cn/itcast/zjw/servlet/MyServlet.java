package cn.itcast.zjw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: MyServlet.java
 * @Description:自己编写的servlet的注入，当不使用注解方式的时候，还需要在启动类中进行相关代码的编写
 * @Time 2017年9月19日
 * @author: Tom
 */
//@WebServlet(urlPatterns="/myServlet2/*",description="Servlet的说明")使用注解注入时候的，在启动类上面也需要注入ServletComponentScan注解
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>HelloWorld</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>这是：MyServlet1</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
