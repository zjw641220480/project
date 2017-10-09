package cn.itcast.zjw.shiro.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.shiro.service.SysService;

/**
 *
 * <p>
 * Title:LoginController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author TOM
 * @date 2017年3月19日下午8:24:04
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource(name = "sysServiceImpl")
	private SysService sysService;

	/**
	 * 
	 * @MethodName:login
	 * @Description:登录
	 * @param session
	 * @param randomcode
	 * @param usercode
	 * @param password
	 * @return
	 * @throws Exception
	 * @Time:2017年3月19日下午8:35:37
	 * @author:Tom
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, String randomcode, String usercode, String password)
			throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("aaa", "bbb");
		System.out.println("LoginController.login()");
		// 如果登录失败从request中获取认证异常信息，shiroLoginFailure就是异常类的全限定名；
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定的异常信息；
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				throw new RuntimeException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new RuntimeException("用户名/密码错误");
			} else {
				throw new Exception();
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/welcome");
		return modelAndView;
		//此方法不处理登录成功（认证成功），shiro认证成功，会自动跳转到上一个请求路径
	}
	
	/**
	 * 
	 * @Method:testPersion
	 * @Description:权限的相关测试，有权限则正常请求，
	 * @Time 2017年9月26日 下午3:29:52
	 * @author: Tom
	 * @return
	 */
	@RequestMapping("/testPermission")
	@RequiresPermissions(value = { "item:quer" })//执行这个方法需要用户具有items:query
	public String testPersion() {
		System.out.println("LoginController.testPersion()");
		return "index";
	}
	@RequestMapping("/noPermission")
	public String noPermission() {
		return "refuse";
	}
	/**
	 * 
	 * @MethodName:logout
	 * @Description:退出，这部分代码后面可以删除
	 * @param session
	 * @return
	 * @Time:2017年3月19日下午8:35:33
	 * @author:Tom
	 */
	@RequestMapping("/out")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/first.action";
	}
}
