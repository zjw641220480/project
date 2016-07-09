package cn.itcast.zjw.servlet.response.closecache;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:CloseCache
 * @Description:使用响应头来禁用浏览器缓存;
 * @author TOM
 * @Time: 2016年7月9日下午4:05:14
 */
public class CloseCache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CloseCache() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("hello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
