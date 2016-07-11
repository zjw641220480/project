package cn.itcast.zjw.servlet.response.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:RedirectSendB
 * @Description:演示重定向的第二种方式
 * @author TOM
 * @Time: 2016年7月9日下午3:44:49
 */
public class RedirectSendB extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//直接一句话实现重定向功能
		System.out.println("第二种方式实现重定向\t"+this.toString());
		resp.sendRedirect("/tom-web/RedirectSendC");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
