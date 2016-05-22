package org.shiro.demo;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * 最主要的对象有三个,Subject(用户),SecruityManager(用户委托的执行者),Realm(DataSource)
 * @author Administrator
 *
 */
public class ShiroDemo {
	/**
	 * 最简单案例的测试
	 */
	@Test
	public void testShiroDemo(){
		 //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		String path = "classpath:shiro\\identity\\shiro.ini";
		Factory<?> factory = new IniSecurityManagerFactory(path);
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		SecurityManager securityManager =  (SecurityManager) factory.getInstance(); 
		//  把securityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证） 
		//上面三步可以理解为收集身份验证;
		Subject subject = SecurityUtils.getSubject();
		//创建token令牌
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "64122");
		try { 
	        //4、登录，即身份验证  
	        subject.login(token);  
	        System.out.println("登录成功");
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	System.out.println("没有登录成功");
	    }  
		subject.logout();
	}
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ShiroDemo.class);
		logger.error("cuowu");
	}
}
