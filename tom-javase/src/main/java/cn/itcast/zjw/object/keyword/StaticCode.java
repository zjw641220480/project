package cn.itcast.zjw.object.keyword;

/** 
* @ClassName: StaticCode 
* @Description: 用来说明静态代码快
* 特点:随着类的加载而执行,只执行一次,用于给类进行初始化,并且优先于主函数进行执行;
* 静态代码块-->构造代码块-->构造方法(这个运行结束之后,类的一个实例对象便存在了)-->实例对象调用相关方法
* @author Tom
* @date 2016-2-27 
*/ 
public class StaticCode {
	private int num = 9;
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("静态代码块运行");
		//静态代码块随着类的加载而运行(类的字节码文件被java虚拟机加载到内存);
		//在静态代码快中不能访问非静态的成员;
		//System.out.println(num);
		System.out.println("StaticCodeAAAAAAAAAAAAA");
	}
	/**
	 * 构造代码块
	 */
	{
		System.out.println("构造代码块运行");
		//在构造代码快中可以访问非静态的成员;
		System.out.println(num);
	}
	/**
	 * 构造方法
	 */
	private StaticCode(){
		System.out.println("构造方法运行");
		System.out.println(this.toString());
		System.out.println("StaticCode.StaticCode()");
	}
	public static void main(String[] args) {
		//即使什么都不写,该类的static代码快一样会执行;
		//虽然左边有StaticDemo的类名,但是不存在有任何有意义的变量名指向;下面类的static代码快不会执行;
		@SuppressWarnings("unused")
		StaticDemo staticDemo = null;
		//创建两个对象,构造代码块和构造方法都会运行两遍
		StaticCode staticCode = new StaticCode();
		StaticCode staticCode2 = new StaticCode();
		System.out.println(staticCode);
		System.out.println(staticCode2);
	}
	
}
class StaticDemo{
	static{
		System.out.println("StaticDemo.enclosing_method()");
	}
	public static void show(){
		System.out.println("StaticDemo.show()");
	}
}
