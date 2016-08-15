package cn.itcast.zjw.base.extend;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.PersonExtends;
import cn.itcast.zjw.base.domain.Student;

public class TestIocExtends {
	/**
	 * 1:
	 * @Method:testIocExtends
	 * @Description:
	 * @author:Tom
	 * @date 2016年8月15日 下午9:38:41
	 */
	@Test
	public void testIocExtends(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/extend/applicationContext.xml");
		PersonExtends personExtends = applicationContext.getBean(PersonExtends.class);
		personExtends.testExtends();
	}
	@Test
	public void testIocExtendsAnnotation(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/extend/applicationContextExtendsAnnotation.xml");
		PersonExtends personExtends = applicationContext.getBean(PersonExtends.class);
		personExtends.testExtends();
	}
}
