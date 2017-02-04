package cn.itcast.zjw.springbase.proxy.cgliproxy;

import org.junit.Test;

public class CglibProxyTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, Throwable {
		// 所需要增强的目标对象
		CglibTargetObject cglibTargetObject = new CglibTargetObject();
		CglibProxy cglibProxy = new CglibProxy();
		CglibTargetObject newCglibTargetObject = (CglibTargetObject) cglibProxy.initCglibTargetObject(cglibTargetObject);
		// CGLIB方式调用的时候出现了点问题
		//cglibProxy.intercept(newCglibTargetObject, newCglibTargetObject.getClass().getMethod("show", String.class), new String[]{"shuru"}, );
	}
}
