package cn.itcast.zjw.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:CookieServletOne
 * @Description:通过response设置Cookie
 * @author TOM
 * @Time: 2016年7月14日下午5:02:50
 */
public class CookieServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServletOne() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("CookieServletOne.doGet()");
		Cookie cookieA = new Cookie("aaa","AAAA");
		Cookie cookieB = new Cookie("bbb","BBBB");
		cookieA.setMaxAge(60);
		response.addCookie(cookieA);
		response.addCookie(cookieB);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
