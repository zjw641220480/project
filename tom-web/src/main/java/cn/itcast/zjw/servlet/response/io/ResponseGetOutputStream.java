package cn.itcast.zjw.servlet.response.io;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:ResponseGetOutputStream
 * @Description:使用Response获取字节流,向页面输出
 * @author TOM
 * @Time: 2016年7月9日下午4:21:05
 */
public class ResponseGetOutputStream extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResponseGetOutputStream() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = "body"+this.toString();
		byte[] bytes = body.getBytes();
		response.getOutputStream().write(bytes);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
