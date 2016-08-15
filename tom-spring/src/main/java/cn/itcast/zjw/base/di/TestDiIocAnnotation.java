package cn.itcast.zjw.base.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.itcast.zjw.base.domain.Person;
/**
 * 
 * @ClassName:TestDiIocAnnotation
 * @Description:
 * @author TOM
 * @Time:2016年8月14日
 */
public class TestDiIocAnnotation {
	/**
	 * 1:启动Spring容器,
	 * 2:当Spring容器解析到
	 * 	<context:component-scan base-package="cn.itcast.zjw.base.domain"></context:component-scan>
	 * 	回去base-package指定的包及其子包中进行扫描所有的类,看哪些类加有@Component注解
	 * 3:如果该类上面有这个注解,检查这个注解的value值是否为空,则会把该注解所在类的类名以类名首字母小写的方式管理该bean;
	 * 	如果该类上面有这个注解,检查这个注解的value值不为空,则会吧注解所在类的以该值作为bean的id值进行管理
	 * 4:扫描,Spring容器中所有的bean,进行resource规则;
	 * @Method:testDiIocAnnotation
	 * @Description:
	 * @author:Tom
	 * @date 2016年8月14日 下午11:24:10
	 */
	@Test
	public void testDiIocAnnotation(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/di/applicationContextDiIocAnnotation.xml");
		Person person = applicationContext.getBean(Person.class);
		person.getStudent().say();
	}
}
