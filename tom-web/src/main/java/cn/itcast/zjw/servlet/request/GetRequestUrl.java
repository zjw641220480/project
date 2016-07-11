package cn.itcast.zjw.servlet.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:GetRequestUrl
 * @Description:使用
 * @author TOM
 * @Time: 2016年7月11日下午8:54:42
 */
public class GetRequestUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRequestUrl() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		//使用request来获取url的相关方法;
		response.getWriter().println("request.getScheme()\t\t"+request.getScheme());//获取请求协议
		response.getWriter().println("request.getServerName()\t\t"+request.getServerName());//获取服务器名称
		response.getWriter().println("request.getServerPort()\t\t"+request.getServerPort());//获取服务器端口号
		response.getWriter().println("request.getContextPath()\t"+request.getContextPath());//获取项目名称
		response.getWriter().println("request.getServletPath()\t"+request.getServletPath());//获取Servlet路径
		response.getWriter().println("request.getQueryString()\t"+request.getQueryString());//获取参数部分
		response.getWriter().println("request.getRequestURI()\t\t"+request.getRequestURI());//获取请求uri,
		response.getWriter().println("request.getRequestURL()\t\t"+request.getRequestURL());//获取请求urL,
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
