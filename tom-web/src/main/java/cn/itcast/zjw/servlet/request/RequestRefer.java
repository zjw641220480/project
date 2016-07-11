package cn.itcast.zjw.servlet.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:RequestRefer
 * @Description:使用Refer来实现防盗链
 * @author TOM
 * @Time: 2016年7月11日下午9:15:38
 */
public class RequestRefer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestRefer() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		if (referer == null) {
			return;
		} else if (referer.toLowerCase().contains("localhost")) {
			System.out.println("Hello, 您可以访问本服务器资源");
		} else {
			response.sendRedirect("http://www.baidu.com");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
