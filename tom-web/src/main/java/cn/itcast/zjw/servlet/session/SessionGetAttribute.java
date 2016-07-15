package cn.itcast.zjw.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @ClassName:SessionGetAttribute
 * @Description:从Session中取出数据
 * @author TOM
 * @Time: 2016年7月14日下午5:30:34
 */
public class SessionGetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionGetAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("SessionGetAttribute.doGet()");
		HttpSession httpSession = request.getSession();
		String nameValue = (String) httpSession.getAttribute("name");
		//一个会话一个SessionId;
		System.out.println("从Session中获得的JSessionID\t"+httpSession.getId());
		System.out.println("从Session中获得的值为:\t"+nameValue);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
