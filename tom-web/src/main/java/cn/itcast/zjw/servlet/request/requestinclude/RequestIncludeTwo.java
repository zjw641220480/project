package cn.itcast.zjw.servlet.request.requestinclude;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestIncludeTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestIncludeTwo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestIncludeTwo.doGet()");
		response.getWriter().println("RequestIncludeTwo.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
