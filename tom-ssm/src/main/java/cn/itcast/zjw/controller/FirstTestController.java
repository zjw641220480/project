package cn.itcast.zjw.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.zjw.service.FirstTestService;

/**
 *
 * <p>Title:FirstTestController.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年3月26日下午10:11:41
 */
@Controller
@RequestMapping("/test")
public class FirstTestController {
	@Resource(name= "firstTestServiceImpl")
	private FirstTestService firstTestService;
	/**
	 * 
	 * @MethodName:first
	 * @Description:测试连通性
	 * @param request
	 * @param response
	 * @Time:2017年4月3日上午7:24:34
	 * @author:Tom
	 */
	@RequestMapping("/first.action")
	public void first(HttpServletRequest request,HttpServletResponse response){
		try {
			System.out.println("FirstTestController.first()");
			this.firstTestService.getUser("1");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
