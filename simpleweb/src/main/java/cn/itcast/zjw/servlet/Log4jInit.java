package cn.itcast.zjw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}

	public Log4jInit() {
		super();
	}

	public void init() throws ServletException {
		String file = this.getInitParameter("log4j");// 从web.xml配置读取，名字一定要和web.xml配置一致
		if (file != null) {
			PropertyConfigurator.configure(file);
		}
	}
}
