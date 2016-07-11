package cn.itcast.zjw.servlet.request.requestinclude;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:RequestIncludeOne
 * @Description:用来演示请求包含
 * @author TOM
 * @Time: 2016年7月11日下午11:24:39
 */
public class RequestIncludeOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestIncludeOne() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestIncludeOne.doGet()");
		//设置响应头
		response.setHeader("aaa", "AAA");
		//下面这一句才是设置相应体
		response.getWriter().print("RequestIncludeOne.doGet()");
		//请求转发,相当于调用RequestForwardTwo的service方法;
		request.getRequestDispatcher("/RequestIncludeTwo").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
