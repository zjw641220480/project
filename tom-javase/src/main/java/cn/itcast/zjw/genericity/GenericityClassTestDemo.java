package cn.itcast.zjw.genericity;

import org.junit.Test;

public class GenericityDemo {
	/**
	 * 先对泛型类进行测试,随后对泛型方法的测试,泛型方法并不要求一定是定义在泛型类中;可以在普通类中独立存在
	 * @Description: TODO   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月9日
	 */
	@Test
	public void testGenericityMethod(){
		GenericityClass<Worker> genericityClass = new GenericityClass<Worker>();
		genericityClass.setT(new Worker());
		genericityClass.getT();
		//--------------------调用泛型方法进行比较测试
		genericityClass.show("泛型方法测试");
		//-------------------静态(static)泛型方法的调用
		GenericityClass.staticMethos("静态泛型方法");
	}
}
