package cn.itcast.zjw.io.readerwriter.buffererreaderwriter.zhuangshi;

import org.junit.Test;

/** 
 * @Description <br/>
	<p>装饰者模式的测试,相当于就是Spring的AOP</p>
 * @author TOM
 * @date 2016年5月19日 下午3:36:04
 */ 
public class TestPersonDemo {
	/** 
	 * @Description <code>原始吃饭方法的调用</code>
	 * @author TOM  
	 */
	@Test
	public void originalPerson() {
		PersonDemo personDemo = new PersonDemo();
		personDemo.chifan();
	}
	/** 
	 * @Description <code>装饰者模式下吃饭方法的调用</code>
	 * @author TOM  
	 */
	@Test
	public void superPerson(){
		PersonDemo personDemo = new PersonDemo();
		SuperPersonDemo superPersonDemo = new SuperPersonDemo(personDemo);
		superPersonDemo.superChifan();
	}
}
