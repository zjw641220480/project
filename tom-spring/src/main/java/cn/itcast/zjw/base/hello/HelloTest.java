package cn.itcast.zjw.base.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Spring容器做的事情:
 * 		解析spring配置文件,利用java的反射机制创建对象,
 * @ClassName:HelloTest
 * @Description:
 * @author TOM
 * @Time: 2016年7月19日下午9:33:16
 */
public class HelloTest {
	@Test
	public void testHello(){
		//启动Spring容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/hello/applicationContext.xml");
		//从spring容器中把对象抽取出来,对象的创建时由spring容器控制的
		Hello hello = (Hello) applicationContext.getBean("hello");
		hello.hello();
		//使用别名方式提取对象
		Hello helloAlias = (Hello) applicationContext.getBean("helloWorld");
		helloAlias.hello();
	}
}
