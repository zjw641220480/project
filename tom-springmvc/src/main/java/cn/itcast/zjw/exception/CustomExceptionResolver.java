package cn.itcast.zjw.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * <p>Title:CustomExceptionResolver.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月13日上午10:23:07
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	/**
	 * 前端控制器DispatcherServlet在进行HandlerMapping,调用HandlerAdapter执行Handler过程,如果遇到异常就会执行此方法
	 * handler形参就是最终要执行的Handler;
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//先把异常输出出来
		ex.printStackTrace();
		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			//针对非CustomException异常,对这类重新构造一个CustomException,异常信息为"未知错误";
			customException = new CustomException("未知错误");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", customException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
