package cn.itcast.zjw.base.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.Person;

public class TestDiAnnotation {
	/**
	 * 1:启动Spring容器
	 * 2:把Spring配置文件中的Bean实例化(Person,Student);
	 * 3:当Spring容器解析配置文件中的
	 * 	<context:annotation-config></context:annotation-config>
	 *  Spring容器会在被纳入Spring所管理的Bena中查找哪些类的属性中有@Resource类型的注解,
	 * 4:如果在类的属性上找到Resource注解,就会进行DI注入(优先name匹配,然后按照类型进行匹配);
	 * 说明:注解代码越来越简单,效率越来越低,而且注解只能用于引用类型;
	 * @Method:testDIAnnotation
	 * @Description:
	 * @author:Tom
	 * @date 2016年8月14日 下午12:42:32
	 */
	@Test
	public void testDIAnnotation(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/di/applicationContextDiAnnotation.xml");
		Person person = applicationContext.getBean(Person.class);
		person.getStudent().say();
	}
}
