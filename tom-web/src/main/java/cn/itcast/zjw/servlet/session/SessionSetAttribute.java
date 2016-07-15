package cn.itcast.zjw.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @ClassName:SessionSetAttribute
 * @Description:向session中存数据
 * @author TOM
 * @Time: 2016年7月14日下午5:20:35
 */
public class SessionSetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionSetAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("name", "zhangsan");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
