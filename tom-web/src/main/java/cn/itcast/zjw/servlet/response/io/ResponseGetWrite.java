package cn.itcast.zjw.servlet.response.io;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:ResponseGetWrite
 * @Description:使用Response获取字符流,向页面输出
 * @author TOM
 * @Time: 2016年7月9日下午4:18:25
 */
public class ResponseGetWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResponseGetWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Hello Word"+this.toString());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
