package cn.itcast.zjw.servlet.response.encode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:ResponseEncode
 * @Description:演示响应编码
 * @author TOM
 * @Time: 2016年7月12日下午9:21:10
 */
public class ResponseEncode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResponseEncode() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器使用的编码,但是浏览器暂时还不知道
		response.setCharacterEncoding("UTF-8");
		//告诉浏览器服务器所使用的编码(这一句实际上顶两句)
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		/*
		 * 一种更加简便的方式设置Content-Type头
		 */
		//response.setContentType("text/heml;charset=utf-8");
		response.getWriter().print("响应编码的设置");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
