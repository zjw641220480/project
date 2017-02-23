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
		//show方法中并没有对泛型的类型进行限定,其可以和类上定义的泛型不同;
		//show方法中使用的泛型和类上定义的泛型一致的时候,这里就只能传递Worker了
		genericityClass.show(new Person());
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
