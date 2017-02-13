package cn.itcast.zjw.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * <p>Title:HandlerInterceptorA.java</p>
 * <p>Description:拦截器</p>
 * @author TOM
 * @date 2017年2月13日下午3:31:34
 */
public class HandlerInterceptorA2 implements HandlerInterceptor {
	/**
	 * 在执行handler之前来执行的
	 * 用于用户认证校验,用户权限校验
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptorA22222222222222222.preHandle()");
		return false;
	}

	/**
	 * 在执行handler返回modelAndView之前来执行的;
	 * 如果需要像页面提供一些共用的数据,或配置一些视图的信息,使用此方法来实现,运用此方法从modelAndView来入手;
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 执行handler之后执行此方法;
	 * 可以作为系统的统一异常处理来使用;进行方法的执行性能的监控;在preHandle中设置一个时间点,在afterCompletion设置一个时间,两个时间点的差就是执行handler的时长;
	 * 实现系统的统一日志;
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
