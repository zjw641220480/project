package cn.itcast.zjw.servlet.request.requestforward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestForwardTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestForwardTwo() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestForwardTwo.doGet()");
		//获取request域中的内容
		System.out.println("request域中的username的值为:\t"+request.getAttribute("username"));
		response.getWriter().println("RequestForwardTwo.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
