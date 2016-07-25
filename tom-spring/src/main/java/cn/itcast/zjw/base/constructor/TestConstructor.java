package cn.itcast.zjw.base.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.Person;

public class TestConstructor {
	/**
	 * 
	 * @Method:testConstructor
	 * @Description:使用构造函数给属性赋值--->constructor-arg
	 * @author Tom
	 * @date 2016年7月24日 下午4:10:25
	 */
	@Test
	public void testConstructor(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/constructor/applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person.getName());
		System.out.println(person.getStudent());
	}
}
