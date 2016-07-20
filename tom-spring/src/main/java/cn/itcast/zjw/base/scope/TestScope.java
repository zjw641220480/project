package cn.itcast.zjw.base.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	/**
	 * 
	 * @Method:testScope_Default
	 * @Description:在默认情况下,Spring容器产生的对象是单例的,
	 * @author TOM
	 * @date 2016年7月19日
	 */
	@Test
	public void testScope_Default(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/scope/applicationContext.xml");
		HelloWorld helloWorldA = (HelloWorld) applicationContext.getBean("helloWorld");
		HelloWorld helloWorldB = (HelloWorld) applicationContext.getBean("helloWorld");
		System.out.println(helloWorldA);
		System.out.println(helloWorldB);
	}
	/**
	 * 
	 * @Method:testScope_Prototype
	 * @Description:将scope改为"prototype",则为多例的
	 * @author TOM
	 * @date 2016年7月19日
	 */
	@Test
	public void testScope_Prototype(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/scope/applicationContext.xml");
		HelloWorld helloWorldA = (HelloWorld) applicationContext.getBean("helloWorld");
		HelloWorld helloWorldB = (HelloWorld) applicationContext.getBean("helloWorld");
		System.out.println(helloWorldA);
		System.out.println(helloWorldB);
	}
}
