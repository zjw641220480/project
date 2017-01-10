package cn.itcast.zjw.servlet.response.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:RedirectSendA
 * @Description:演示重定向,用户请求该Servlet,然后改Servlet相应302状态头,给出Location头
 * @author TOM
 * @Time: 2016年7月9日下午3:26:47
 */
public class RedirectSendA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一种最原始的方式实现重定向;
		/*
		 * 重定向:
		 * 1,设置Location,响应头的首字母一般都大写,只是不进行区分
		 * 2,设置发送的状态码为302;
		 * 3,项目名加请求路径即为请求URI;
		 */
		System.out.println("第一种方式实现重定向运行\t"+this.toString());
		//重定向相对于当前主机:http://127.0.0.1:8080/所以,重定向的路径必须要加项目名
		response.setHeader("Location", "/tom-web/RedirectSendC");
		response.setStatus(302);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
