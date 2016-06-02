package cn.itcast.zjw.innerclass;

public class InnerClassTest {
	public static void main(String[] args) {
		// Test.function():Test类中有一个静态方法,其方法名为function;
		// .method():function()方法运算后的结果是一个对象,而且是一个InnerInterface接口类型的对象.
		// 因为只有是InnerInterface接口类型的对象,才可以调用method方法;
		Test.function().method();
		System.out.println("****************************************");
		Test.test(new InnerInterface() {
			public void method() {
				System.out.println("传参的时候直接传递的是这个匿名内部类");
			}
		});
	}
}

interface InnerInterface {
	void method();
}

class Test {
	// 补足代码,使用匿名内部类
	public static InnerInterface function() {
		InnerInterface innerInterface = new InnerInterface() {

			public void method() {
				System.out.println("InnerInterface接口的匿名内部类实现方式");
			}
		};
		return innerInterface;
	}

	/**
	 * @Title: test
	 * @Description: 传参的时候直接传一个匿名内部类;参数是接口类型的对象
	 * @param in
	 * @return void
	 * @author Tom
	 * @date 2016-3-6
	 */
	public static void test(InnerInterface in) {
		in.method();
	}
}