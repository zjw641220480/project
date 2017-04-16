package cn.itcast.zjw.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String path = httpServletRequest.getServletPath();
		System.out.println(path);
		System.out.println("MyFilter.doFilter()============"+path);
		HttpSession session = httpServletRequest.getSession();
		Object user = session.getAttribute("user");
		List<String> urls = new ArrayList<String>();
		if(user!=null){//已经登录
			chain.doFilter(request, response);
		}else{//没有登录
			if(urls.contains(path)){//主页
				chain.doFilter(request, response);
			}else{
				//这里面不要使用重定向
				if(path.equals("/test/index.jsp")){
					chain.doFilter(request, response);
				}else{
					httpServletResponse.sendRedirect("/test/index.jsp");
					return;
				}
				//httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
