/**
 * @Project: tom-mybatis-spring @(#) PersonTest.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.springbase.createobject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * @ClassName: PersonTest
 * @Description:
 * @Time 2016年5月26日 下午10:42:29
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class PersonTest {

	/**
	 * @Method: setUp
	 * @Description:
	 * @param: @throws java.lang.Exception 
	 * @return: void
	 * @date 2016年5月26日
	 * @author TOM
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPerson() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring/applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		Person person2 = (Person) applicationContext.getBean("person");
		System.out.println(person2);
	}

}
