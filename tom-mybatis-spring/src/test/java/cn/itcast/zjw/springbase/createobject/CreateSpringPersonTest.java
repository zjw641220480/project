package cn.itcast.zjw.springbase.createobject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.controller.test.MyTest;

public class CreateSpringPersonTest {
	ApplicationContext applicationContext = null;
	@Before
	public void before(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/springbase/createobject/applicationContext-createObject.xml");
	}
	@Test
	public void testSpringPerson() {
		SpringPerson springPerson1 = (SpringPerson) applicationContext.getBean("springPerson");
		System.out.println(springPerson1);
		SpringPerson springPerson2 = (SpringPerson) applicationContext.getBean("springPerson");
		System.out.println(springPerson2==springPerson1);
	}
	@Test
	public void testSpringPersonFactory(){
		SpringPerson springPerson1 = (SpringPerson) applicationContext.getBean("springPersonFactory");
		System.out.println(springPerson1);
		SpringPerson springPerson2 = (SpringPerson) applicationContext.getBean("springPersonFactory");
		System.out.println(springPerson1==springPerson2);
	}
	@Test
	public void testTestController(){
		MyTest myTest = (MyTest) applicationContext.getBean("myTest");
		myTest.show();
	}
}
