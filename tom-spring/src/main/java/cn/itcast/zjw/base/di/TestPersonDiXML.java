package cn.itcast.zjw.base.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.domain.Person;
/**
 * 当使用到该Bean的时候,就必须要为该bean创建对象,不论该bean的lazy-init和scope为什么值;
 * 首先就需要保证各个Bean能正常工作;
 * @ClassName:TestPersonDiXML
 * @Description:
 * @author Tom
 * @Time:2016年7月24日
 *
 */
public class TestPersonDiXML {
	/**
	 * 1,启动Spring容器,
	 * 2,给person,student创建对象
	 * 3,调用person各个set方法,对属性进行赋值
	 * 4,调用applicationContext.getBean("");方法
	 * 5,对象调用方法;
	 * @Method:testPersonDi
	 * @Description:
	 * @author Tom
	 * @date 2016年7月24日 下午2:33:38
	 */
	//当需要使用到init方法的时候,init是在所有的set方法运行完毕之后才会执行init方法的;
	@Test
	public void testPersonDiXML(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/di/applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person.getName());
		System.out.println(person.getStringList());
	}
}
