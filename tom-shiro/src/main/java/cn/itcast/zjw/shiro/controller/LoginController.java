package cn.itcast.zjw.shiro.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.zjw.shiro.exception.CustomException;
import cn.itcast.zjw.shiro.po.ActiveUser;
import cn.itcast.zjw.shiro.service.SysService;

/**
 *
 * <p>Title:LoginController.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年3月19日下午8:24:04
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource(name = "sysServiceImpl")
	private SysService sysServiceImpl;
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
	@RequestMapping("/login.action")
	public String login(HttpSession session,String randomcode,String usercode,String password) throws Exception{
		//校验验证码,放置恶性攻击
		//从session获取正确的验证码
		String validateCode = (String) session.getAttribute("validateCode");
		if(validateCode.equals(randomcode)){
			//抛出异常
			throw new CustomException("验证码输入错误");
		}
		//调用service校验用户账号和密码的正确性;
		ActiveUser activeUser = sysServiceImpl.authenticat(usercode, password);
		session.setAttribute("activeUser", activeUser);
		return "redirect:/first.action";
	}
	/**
	 * 
	 * @MethodName:logout
	 * @Description:退出
	 * @param session
	 * @return
	 * @Time:2017年3月19日下午8:35:33
	 * @author:Tom
	 */
	@RequestMapping("/out.action")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/first.action";
	}
}
