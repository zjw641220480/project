package cn.itcast.zjw.base.createobject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @ClassName:CreateObjectMethodTest
 * @Description:Spring的3种创建对象的方式;
 * @author TOM
 * @Time: 2016年7月19日下午10:12:04
 */
public class CreateObjectMethodTest {
	/**
	 * 
	 * @Method:testCreateObjectDefaultConstruct
	 * @Description:spring容器在默认情况下使用默认的构造函数创建对象;
	 * @author TOM
	 * @date 2016年7月19日
	 */
	@Test
	public void testCreateObjectDefaultConstruct(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/createobject/applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorldDefaultConstruct");
		helloWorld.hello();
	}
	/**
	 * 在spring容器内部,调用了HelloWorldFactory中的getInstance方法,而该方法的内容就是创建对象的过程;
	 * @Method:testCreateObjectStaticFactory
	 * @Description:静态工厂方法创建对象;(通过工厂类中的静态方法创建对象)
	 * @author TOM
	 * @date 2016年7月19日
	 */
	@Test
	public void testCreateObjectStaticFactory(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/createobject/applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorldFromFactory");
		helloWorld.hello();
	}
	/**
	 * 1:spring容器实例化工厂类,
	 * 2:该实例化工厂bean调用了普通工厂方法getInstance产生指定的对象;
	 * @Method:testCreateObjectInstanceFactory
	 * @Description:通过实例工厂来创建对象(通过实例化工厂,调用工厂类中的普通的创建对象方法)
	 * @author TOM
	 * @date 2016年7月19日
	 */
	@Test
	public void testCreateObjectInstanceFactory(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/createobject/applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorldFacotryObject");
		helloWorld.hello();
	}
}
