package cn.itcast.zjw.innerclass;

/** 
* @ClassName: InnerClass 
* @Description:内部类基本知识
* 内部类的访问规则:
* 	1,内部类可以直接外部类中成员,而且是包括私有的成员
* 		之所以可以直接访问外部类中的成员,是因为内部类中持有了一个外部类的引用,格式:外部类名.this
* 	2,外部类要访问内部类,必须要建立内部类的对象
* 访问格式:
* 当内部类定义在外部类的成员位置上,而且非私有,可以在外部的其他类中可以直接建立内部类的对象格式是:
* 	外部类名.内部类名	 变量名 = 外部类对象.内部类对象;
* 	Outer.Inner inner = new Outer().new Inner();
* 当内部类在成员变量的位置上,就可以被成员修饰符锁修饰,
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
public class InnerClass {
	public static void main(String[] args) {
//		Outer outer = new Outer();
//		outer.method();
		//直接访问内部类中的成员,此内部类不能是private级别的,而且不能是被static所修饰了的内部类
//		Outer.Inner inner = new Outer().new Inner();
//		inner.function();
//		Outer.Inner inner = new Outer.Inner();//静态所修饰的内部类的创建方式;
//		inner.function();
		Outer outer = new Outer();
		//参数在方法中定义成了常量,然后,由于方法的进栈和出栈的问题,可以进行这样的调用;
		outer.show(7);
		outer.show(10);
	}
}
class Outer{
	private int x = 3;

	public void method() {
		System.out.println("外部类中的方法\t"+x);
	}

	public void show(final int a){
		System.out.println("匿名内部类");
		final int y = 4;
		//局部内部类中是不可以有private和static这两个关键词的
		@SuppressWarnings("hiding")
		class Inner{
			void function(){
				System.out.println("匿名内部类中的函数");
				System.out.println("访问局部变量y,这个y必须是final"+y);
				System.out.println("内部类中带有参数的方法,传递的参数的值是:\t"+a);
			}
		}
		new Inner().function();
	}
	static class Inner {//内部类
		private int x = 4;
		public void function() {
			@SuppressWarnings("unused")
			int x =5;
			System.out.println("内部类中的function方法\t"+this.x);
		}
	}
	
}
