package cn.itcast.zjw.genericity;

import org.junit.Test;

public class GenericityClassTestDemo {
	/**
	 * 
	 * @Method:testGenericityMethodSet
	 * @Description:测试泛型类中的setT()方法
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testGenericityMethodSet(){
		GenericityClass<Worker> genericityClass = new GenericityClass<Worker>();
		genericityClass.setT(new Worker());
	}
	/**
	 * 
	 * @Method:testGenericityMethodGet
	 * @Description:测试泛型类中的get方法
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testGenericityMethodGet(){
		GenericityClass<Worker> genericityClass = new GenericityClass<Worker>();
		genericityClass.getT();
	}
	/**
	 * 
	 * @Method:testGenericityMethodShow
	 * @Description:测试泛型类中的show方法
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testGenericityMethodShow(){
		GenericityClass<Worker> genericityClass = new GenericityClass<Worker>();
		genericityClass.show(new Worker());
	}
	/**
	 * 
	 * @Method:testGenericityMethodStaticShow
	 * @Description:静态方法中泛型类的使用
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testGenericityMethodStaticShow(){
		GenericityClass.staticMethos(new Worker());
	}
}
