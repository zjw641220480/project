package cn.itcast.zjw.servlet.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:BaseResponse
 * @Description:最简单的一个演示HttpServletResponse的类,演示发送状态吗
 * @author TOM
 * @Time: 2016年7月9日下午2:49:58
 */
public class BaseResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendError(404, "您访问的资源存在,但就是不给你看");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
