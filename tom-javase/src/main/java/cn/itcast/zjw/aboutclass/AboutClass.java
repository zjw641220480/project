package cn.itcast.zjw.aboutclass;

import org.junit.Test;

import cn.itcast.zjw.reflect.Person;

public class AboutClass {
	/**
	 * @Method:testAboutClass
	 * @Description:用来演示Class这个类的相关方法;
	 * @author TOM
	 * @throws ClassNotFoundException 
	 * @date 2016年7月14日
	 */
	@Test
	public void testAboutClass() throws ClassNotFoundException{
		Class<Person> personClass = (Class<Person>) Class.forName("cn.itcast.zjw.reflect.Person");
		System.out.println(personClass);
	}
}
