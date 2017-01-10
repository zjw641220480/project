package cn.itcast.zjw.innerclass;

import org.junit.Test;
/**
 * 
 * @ClassName:InnerClassTest
 * @Description:匿名内部类的两种使用方式:
 * 1,方法中使用接口对象,接口使用匿名内部类来实例化
 * 2,参数为接口对象,在传参的时候直接使用匿名内部类来实例化该接口对象;
 * @author TOM
 * @Time: 2016年7月16日下午10:58:07
 */
public class InnerClassTest {
	/**
	 * 
	 * @Method:testStandardInnerClass
	 * @Description:标准的匿名内部类实例化接口使用的测试
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testStandardInnerClass(){
		//这种方式的调用,接口中的方法不会运行,只是将接口进行实例化而已,需要自己再进行手动调用;
		InnerInterface innerInterface = StandardInnerClass.function();
		innerInterface.method();
		//下面依据直接顶上面两句
		//StandardInnerClass.function().method();
	}
	/**
	 * 
	 * @Method:testInnerInterfaceParam
	 * @Description:传递的参数直接是一个接口对象,(匿名内部类方式实例化该接口)
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testInnerInterfaceParam(){
		StandardInnerClass.testInnerInterfaceParam(new InnerInterface() {
			public void method() {
				System.out.println(this.toString());
				System.out.println("InnerClassTest.testInnerInterfaceParam().new InnerInterface() {...}.method()");
				System.out.println("传参的时候直接传递的是这个匿名内部类");
			}
		});
	}
}

interface InnerInterface {
	void method();
}

class StandardInnerClass {
	// 补足代码,使用匿名内部类
	/**
	 * 
	 * @Method:function
	 * @Description:普通类中的普通方法,但是方法体中用到了一个接口对象,直接把接口进行实例化,重写了接口中的抽象方法
	 * @author TOM
	 * @date 2016年7月16日
	 * @return
	 */
	public static InnerInterface function() {
		InnerInterface innerInterface = new InnerInterface() {
			//接口中需要重写的方法;
			public void method() {
				System.out.println(this.toString());
				System.out.println("StandardInnerClass.function().new InnerInterface() {...}.method()");
				System.out.println("方法中使用接口对象,InnerInterface接口的匿名内部类实现方式");
			}
		};
		return innerInterface;
	}

	/**
	 * @Title: testInnerInterfaceParam
	 * @Description: 传参的时候直接传一个匿名内部类;参数是接口类型的对象
	 * @param in
	 * @return void
	 * @author Tom
	 * @date 2016-3-6
	 */
	public static void testInnerInterfaceParam(InnerInterface in) {
		in.method();
	}
}