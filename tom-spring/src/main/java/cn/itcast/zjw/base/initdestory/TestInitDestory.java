package cn.itcast.zjw.base.initdestory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.HelloWorld;



public class TestInitDestory {
	/**
	 * 1,启动Spring容器
	 * 2,applicationContext.getBean("");这句话运行时候才会去创建对象;
	 * 3,创建HelloWorld对象,
	 * 4,执行init方法,该方法是由Spring容器内部调用
	 * 5,对象调用方法
	 * 6,当执行close方法的时候,执行该对象的destroy方法,该方法也是由Spring容器内部调用
	 * @Method:testInitDestoryMethod
	 * @Description:
	 * @author Tom
	 * @date 2016年7月24日 上午10:06:57
	 */
	//当该对象的scope属性为prototype的时候,Spring容器不再负责对对象的销毁了;
	@Test
	public void testInitDestoryMethodScopePrototype(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/initdestory/applicationContext.xml");
		HelloWorld helloWorldA = (HelloWorld) applicationContext.getBean("helloWorldScopePrototype");
		HelloWorld helloWorldB = (HelloWorld) applicationContext.getBean("helloWorldScopePrototype");
		System.out.println(helloWorldA);
		System.out.println(helloWorldB);
		ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
		classPathXmlApplicationContext.close();
	}
	/**
	 * Scope的值为default的时候,该Bean才会全程由Spring进行管理;
	 * 1,启动Spring容器,
	 * 2,创建HelloWorld对象,该方法是由Spring容器内部调用
	 * 3,执行init方法
	 * 4,applicationContext.getBean("");
	 * 5,对象调用方法
	 * 6,当执行close方法的时候,执行该对象的destroy方法,该方法也是由Spring容器内部调用
	 * @Method:testInitDestoryMethodScopeDefault
	 * @Description:
	 * @author Tom
	 * @date 2016年7月24日 下午1:52:55
	 */
	@Test
	public void testInitDestoryMethodScopeDefault(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/initdestory/applicationContext.xml");
		HelloWorld helloWorldA = (HelloWorld) applicationContext.getBean("helloWorldScopeSingle");
		HelloWorld helloWorldB = (HelloWorld) applicationContext.getBean("helloWorldScopeSingle");
		System.out.println(helloWorldA);
		System.out.println(helloWorldB);
		ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
		classPathXmlApplicationContext.close();
	}
}
