package cn.itcast.zjw.base.lazyscope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.HelloWorld;

public class TestLzyScope {
	/**
	 * 如果scope为prototype,那么lazy-init属性将失去效果,在对象被调用的时候才会进行初始化
	 * @Method:testScopePrototypeLzayDefault
	 * @Description:
	 * @author Tom
	 * @date 2016年7月24日 上午9:55:14
	 */
	@Test
	public void testScopePrototypeLzayDefault(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/lazyscope/applicationContext.xml");
		HelloWorld helloWorldA = (HelloWorld) applicationContext.getBean("helloWorld");
		HelloWorld helloWorldB = (HelloWorld) applicationContext.getBean("helloWorld");
		System.out.println(helloWorldA);
		System.out.println(helloWorldB);
	}
}
