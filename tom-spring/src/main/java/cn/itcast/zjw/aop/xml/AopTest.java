package cn.itcast.zjw.aop.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	/**
	 * 
	 * @MethodName:testAopXml
	 * @Description:
	 * @Time: 2017年7月8日 上午8:04:08
	 * @author: TOM
	 */
	@Test
	public void testAopXml(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/aop/xml/applicationContext-AopXml.xml");
		Target target = applicationContext.getBean(Target.class);
		target.runTargetMethod();
	}
	@Test
	public void testAopAnnotation(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/aop/xml/applicationContext-AopAnnnotation.xml");
		Target target = applicationContext.getBean(Target.class);
		target.runTargetMethod();
	}
}
