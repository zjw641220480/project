package cn.itcast.zjw.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:CookieServletTwo
 * @Description:获取Cookie中的值
 * @author TOM
 * @Time: 2016年7月14日下午5:03:42
 */
public class CookieServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServletTwo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("CookieServletTwo.doGet()");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+"="+cookie.getValue());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
