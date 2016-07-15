package cn.itcast.zjw.servlet.request.encode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:RequestEncode
 * @Description:请求编码设置,请求编码的处理分为get和post两种方式
 * @author TOM
 * @Time: 2016年7月12日下午9:54:11
 */
public class RequestEncode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestEncode() {
        super();
    }
    /*
     * Get方式乱码的处理方式
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestEncode.doGet()");
		/*
		 * 1,先获取使用ISO-8859-1编码的错误字符串
		 * 2,(iso)回退到字节数组,使用utf-8再进行重组;
		 */
		String paramUserName = request.getParameter("username");
		//将最初获得的参数使用ISO-8859-1反编为字节数组
		byte[] bytes = paramUserName.getBytes("ISO-8859-1");
		//使用UTF-8重新编译此字节数组,从而使得数据不会出现乱码;
		String userName = new String(bytes,"UTF-8");
		System.out.println("客户端传递来的用户名为:\t"+userName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

}
