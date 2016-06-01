package cn.itcast.zjw.springbase.proxy.jdkproxy;

import org.junit.Test;

import cn.itcast.zjw.springbase.initelements.InitElementsPerson;

public class JdkProxyTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, Throwable {
		// 第一步准备目标对象
		JdkTargetObject targetObject = new JdkTargetObject();
		// 声明代理对象,
		JdkProxy jdkProxy = new JdkProxy();
		// 这个是对代理类中的目标对象初始化
		jdkProxy.createProxyInstance(targetObject);
		// 代理对象在调用目标对象方法的时候,其有一个前提,那就是:代理对象中要有一个目标对象实例
		InitElementsPerson returnObject = (InitElementsPerson) jdkProxy.invoke(targetObject, targetObject.getClass().getMethod("show", String.class), new String[]{"param参数"});
		System.out.println(returnObject);
	}
	@Test
	public void test2() throws NoSuchMethodException, SecurityException, Throwable{
		JdkTargetObject targetObject = new JdkTargetObject();
		JdkProxy jdkProxy = new JdkProxy();
		InitElementsPerson returnObject = (InitElementsPerson) jdkProxy.invoke(jdkProxy.createProxyInstance(targetObject), targetObject.getClass().getMethod("show", String.class), new String[]{"param参数"});
		System.out.println(returnObject);
	}
}
