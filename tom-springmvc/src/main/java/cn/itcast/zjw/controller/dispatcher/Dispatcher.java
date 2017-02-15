package cn.itcast.zjw.controller.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * <p>Title:Dispatcher.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月15日上午9:39:14
 */
@Controller
@RequestMapping("/forward")
public class Dispatcher {
	/**
	 * 
	 * @MethodName:testForwardReturnVoidA
	 * @Description:void形式的请求转发
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @Time:2017年2月15日上午9:41:18
	 * @author:Tom
	 */
	@RequestMapping("/testForwardReturnVoidA")
	public void testForwardReturnVoidA(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Dispatcher.testForwardReturnVoid()AAAAAAAAAAAAAA");
		request.getRequestDispatcher("testForwardReturnModelAndVoid.action").forward(request, response);
	}
	@RequestMapping("/testForwardReturnVoidB")
	public void testForwardReturnVoidB(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Dispatcher.testForwardReturnVoidB()BBBBBBBBB");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@RequestMapping("/testForwardReturnModelAndVoid")
	public ModelAndView testForwardReturnModelAndVoid(){
		System.out.println("Dispatcher.testForwardReturnModelAndVoid()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		//int a = 1/0;
		return modelAndView;
	}
}	
