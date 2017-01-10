package cn.itcast.zjw.springbase.initelements;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitElementsPersonTest {
	ApplicationContext applicationContext = null;
	@Before
	public void before(){
		applicationContext = new ClassPathXmlApplicationContext("spring/springbase/initelements/applicationContext-initElements.xml");
	}
	@Test
	public void testInitElementsPersonConstruct() {
		InitElementsPerson elementsPerson = (InitElementsPerson) applicationContext.getBean("initElementsPersonConstructor");
		System.out.println(elementsPerson.getName());
	}
	@Test
	public void testInitElementsPersonSetter(){
		InitElementsPerson elementsPerson = (InitElementsPerson) applicationContext.getBean("initElementsPersonSetter");
		System.out.println(elementsPerson.getName());
		// 装配List
		System.out.println(elementsPerson.getList());
		System.out.println(elementsPerson.getList().getClass().getName());
		// 装配Set
		System.out.println(elementsPerson.getSet());
		System.out.println(elementsPerson.getSet().getClass().getName());
		// 装配Map
		System.out.println(elementsPerson.getMap());
		System.out.println(elementsPerson.getMap().getClass().getName());
	}
}
