package cn.itcast.zjw.innerclass;

import org.junit.Test;
/** 
* @ClassName: InnerClass 
* @Description:内部类基本知识
* 内部类的访问规则:
* 	1,内部类可以直接访问外部类中的成员,而且是包括私有的成员
* 		之所以可以直接访问外部类中的成员,是因为内部类中持有了一个外部类的引用,格式:外部类名.this
* 	2,外部类要访问内部类,必须要建立内部类的对象
* 访问格式:
* 当内部类定义在外部类的成员位置上,而且非私有,同时没有被static锁修饰可以在外部的其他类中可以直接建立内部类的对象格式是:
* 	外部类名.内部类名	 变量名 = 外部类对象.内部类对象;
* 	Outer.Inner inner = new Outer().new Inner();
* 当内部类在成员变量的位置上,就可以被成员修饰符所修饰,
* 	比如private:将内部类在外部类中进行封装,
* 		static:内部类被这个关键字修饰后,内部类就具备了static的特性,此时只能访问外部类中的static成员,出现了访问局限;
* 	在外部其他类中,如何直接访问static内部类的非静态成员;
* 		格式:外部类名.内部类名	 变量名 = 外部类名.内部类对象;
* 		Outer.Inner inner = new Outer.Inner();//静态所修饰的内部类的创建方式;
* 	在外部其他类中,如何直接访问static内部类的静态成员;
* 		Outer.Inner.function();
* 当内部类中定义了静态成员,那么该内部类也必须是static的
* 当外部类中静态方法访问内部类的时候,内部类也必须是static的,
* 
* 使用规则:
* 	当描述事物的时候,事物的内部还有事物,该事物用内部类来描述,因为内部事物在使用外部事物的内容,
* @author Tom
* @date 2016-3-6 
*/ 

public class InnerClassDemo {
	/**
	 * 
	 * @Method:testCommonInnerClass
	 * @Description:关于最简单,最标准内部类的测试
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testCommonInnerClass(){
		//最简单最正常内部类实例对象的创建方式
		Outer.Inner commonInner = new Outer().new Inner();
		commonInner.function();
	}
	/**
	 * 
	 * @Method:testStaticInnerClass
	 * @Description:被static所修饰了的内部类的测试
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testStaticInnerClass(){
		//static所修饰的内部类的创建方式
		Outer.StaticInner staticInner = new Outer.StaticInner();
		staticInner.function();
	}
	/**
	 * 
	 * @Method:testLocalInnerClass
	 * @Description:外部类方法中的内部类(也即内部类是作为局部变量性质而存在)
	 * @author TOM
	 * @date 2016年7月16日
	 */
	@Test
	public void testLocalInnerClass(){
		Outer outer = new Outer();
		outer.show(4);
	}
}
/**
 * 
 * @ClassName:Outer
 * @Description:这个外部类中包含有三个内部类,一个静态内部类,一个正常的内部类,和一个局部类型的内部类(相当于Thread)
 * @Time:2017年2月23日
 * @author:Tom
 */
class Outer{
	private int x = 1;
	private static int y = 2;
	public void method() {
		System.out.println("外部类中的方法\t"+x);
	}
	/**
	 * 
	 * @Method:show
	 * @Description:在外部类的方法中存在有内部类,
	 * @author TOM
	 * @date 2016年7月16日
	 * @param a
	 */
	//参数在方法中定义成了常量,然后,由于方法的进栈和出栈的问题,可以进行这样的调用;
	public void show(final int a){
		final int y = 3;
		//局部内部类中是不可以有private和static这两个关键词的
		@SuppressWarnings("hiding")
		class Inner{
			void function(){
				System.out.println(this.toString());
				System.out.println("Outer.show(...).Inner.function()");
				System.out.println("匿名内部类中的函数");
				System.out.println("访问成员变量x:\t"+x);
				System.out.println("访问静态成员变量y:\t"+Outer.y);
				//下面两种变量都是需要被final所修饰的
				System.out.println("访问局部变量y,这个y必须是final:\t"+y);
				System.out.println("内部类中带有参数的方法,传递的参数的值是:\t"+a);
			}
		}
		new Inner().function();
	}
	/**
	 * 
	 * @ClassName:StaticInner
	 * @Description:被static所修饰了的内部类,这种内部类只能是访问外部类中也被static所修饰的变量
	 * @author TOM
	 * @Time: 2016年7月16日下午10:28:08
	 */
	//只能是访问外部类中的static修饰了的变量
	public static class StaticInner {//static内部类
		//private int x = 4;
		public void function() {
			//int x =5;
			System.out.println(StaticInner.class);
			System.out.println("Outer.StaticInner.function()");
			System.out.println("static类型的内部类中的function方法\t"+y);
		}
	}
	/**
	 * 
	 * @ClassName:Inner
	 * @Description:最简单最正常的一个public级别的内部类,当为private级别时候,不能被其它外部类所引用
	 * @author TOM
	 * @Time: 2016年7月16日下午10:27:47
	 */
	protected  class Inner{
		public void function() {
			int y = 10;
			System.out.println(this.toString());
			System.out.println("Outer.Inner.function()");
			System.out.println("普通的内部类中的function方法\t"+y);
		}
	}
}
