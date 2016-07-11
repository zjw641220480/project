package cn.itcast.zjw.servlet.response.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:RedirectSendC
 * @Description:重定向目的所在Servlet
 * @author TOM
 * @Time: 2016年7月9日下午3:34:41
 */
public class RedirectSendC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("重定向目的Servlet运行\t"+this.toString());
		response.getWriter().append("Served at: ").append(request.getContextPath()+this.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
