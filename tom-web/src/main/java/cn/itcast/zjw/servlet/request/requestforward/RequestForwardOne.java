package cn.itcast.zjw.servlet.request.requestforward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:RequestForwardOne
 * @Description:演示forward的第一个请求
 * @author TOM
 * @Time: 2016年7月11日下午11:00:47
 */
public class RequestForwardOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestForwardOne() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestForwardOne.doGet()");
		//设置响应头
		response.setHeader("aaa", "AAA");
		//下面这一句才是设置相应体
		response.getWriter().print("这个是第一个请求中response相应体中的内容");
		//向request域中添加一个属性
		request.setAttribute("username", "zhangsna");
		//请求转发,相当于调用RequestForwardTwo的service方法;
		//请求转发和请求包含的路径是相对当前项目路径,http://127.0.0.1:8080/项目名/,所以它的路径前面是没有项目名的;
		request.getRequestDispatcher("/RequestForwardTwo").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
