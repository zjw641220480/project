package cn.itcast.zjw.aop.proxy.jdkproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import cn.itcast.zjw.base.domain.Person;
/**
 * 代理类,既要有目标类的引用,还要实现InvocationHandler接口,实现此接口中的方法;
 * @ClassName:TestJdkProxy
 * @Description:用于对Jdk动态代理进行测试,最主要的就是对代理类的书写
 * @Time:2016年8月16日
 * @author:Tom
 */
public class TestJdkProxy {
	/**
	 * 
	 * @MethodName:testJdkProxy
	 * @Description:对Jdk动态代理模式进行测试;
	 * @throws Throwable
	 * @Time:2016年8月16日下午11:09:24
	 * @author:Tom
	 */
	@Test
	public void testJdkProxy() throws Throwable{
		//1:准备目标对象
		JdkTargetObject jdkTargetObject = new JdkTargetObject();
		//2:准备代理对象
		JdkProxyObject jdkProxyObject  = new JdkProxyObject(jdkTargetObject);
		//3:初始化代理对象
		jdkProxyObject.createProxyInstance(jdkTargetObject);
		//4:执行对应方法
		Person person = (Person) jdkProxyObject.invoke(jdkTargetObject, jdkTargetObject.getClass().getMethod("showPersonName", String.class), new String[]{"张三"});
		System.out.println(person.getName());
	}
	
}
