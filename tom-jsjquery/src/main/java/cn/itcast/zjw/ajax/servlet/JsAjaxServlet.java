package cn.itcast.zjw.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.PlatformManagedObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsAjaxServlet extends HttpServlet {

	/** @Fields serialVersionUID: */
	  	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("GET请求成功");
		response.getWriter().write("GET请求成功:\t参数为id=\t"+id+";name="+username);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("POST请求成功");
		response.getWriter().write("POST请求成功:\t参数为id=\t"+id+";name="+username);
	}

}
