package cn.itcast.zjw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * 
 * @ClassName: MyFilter
 * @Description: SpringBoot中过滤器的配置，直接使用@WebFilter配置即可，启动类中加上@ServletComponentScan注解即可
 * @author: TOM
 * @Time: 2017年9月19日
 */
//@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		System.out.println("执行过滤操作\t"+httpServletRequest.getRequestURL());
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		 System.out.println("过滤器销毁");
	}

}
