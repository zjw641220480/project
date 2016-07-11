package cn.itcast.zjw.servlet.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:GetRequestHeader
 * @Description:演示获取客户端的Ip地址,获取请求方式,获取User-Agent,得到客户端的信息(操作系统,浏览器);
 * @author TOM
 * @Time: 2016年7月10日上午10:36:06
 */
public class GetRequestHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRequestHeader() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取IP地址
		String ipAddress = request.getRemoteAddr();
		System.out.println(ipAddress+"\t"+this.toString());
		//获取请求方式
		System.out.println(request.getMethod()+"\t"+this.toString());
		//获取名为User-Agent的头;
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent+"\t"+this.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
