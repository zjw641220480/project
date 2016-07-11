package cn.itcast.zjw.servlet.response.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:RefreshRedirect
 * @Description:演示定时刷新,设置一个Refresh头,它表示定时刷新
 * @author TOM
 * @Time: 2016年7月9日下午3:54:25
 */
public class RefreshRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RefreshRedirect() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("定时刷新功能实现\t"+this.toString());
		//下面用来发送页面相应体
		response.getWriter().print("Welocome");
		//定时刷新相应头的设置;可以没有url=
		response.setHeader("Refresh", "5;/tom-web/RedirectSendC");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
