package cn.itcast.zjw.servlet.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * <p>Titile:MySessionListener</p>
 * <p>Description:
 * 	（1）该程序实现了HttpSessionListener接口类中的两个方法：

		● sessionCreated(HttpSessionEvent arg0)方法进行Http会话创建的监听，如果Http会话被创建将调用该方法。

		● sessionDestroyed(HttpSessionEvent arg0)方法对Http会话销毁进行监听，如果某个Http会话被释放将调用该方法。

	（2）实现HttpSessionActivationListener接口类中的如下两个方法：

		● sessionDidActivate(HttpSessionEvent arg0)方法对Http会话处于active情况进行监听。

		● sessionWillPassivate(HttpSessionEvent arg0)方法对Http会话处于passivate情况进行监听。

	（3）实现HttpSessionAttributeListener接口类中的如下3种方法：

		● attributeAdded(HttpSessionBindingEvent arg0)方法对Http会话中属性添加进行监听。

		● attributeReplaced(HttpSessionBindingEvent arg0)方法对Http会话中属性修改进行监听。

		● attributeRemoved(HttpSessionBindingEvent arg0)方法对Http会话中属性删除进行监听。
 *  </p>
 * @author TOM
 * @date 2017年7月24日 下午5:04:38
 */
public class MySessionListener implements HttpSessionActivationListener,HttpSessionAttributeListener,HttpSessionListener{
	private HttpSession session = null;
	public void sessionCreated(HttpSessionEvent se) {
		this.session = se.getSession();
		System.out.println("HttpSession创建的监听:\t"+session.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession销毁的监听:\t"+session.getId());
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		session.setAttribute("key", "val");
		System.out.println("HttpSession新增变量的监听:\t"+session.getId());
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		session.removeAttribute("key");
		System.out.println("HttpSession移除变量的监听:\t"+session.getId());
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		session.setAttribute("key", "newVla");
		System.out.println("HttpSession更新变量的监听:\t"+session.getId());
	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		
	}

	public void sessionDidActivate(HttpSessionEvent se) {
		
	}

}
