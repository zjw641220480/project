package cn.itcast.zjw.innerclass;
/**
 * 
 * @ClassName:AnonymityInnerClass
 * @Description:以匿名内部类方式重写抽象类
 * @author TOM
 * @Time: 2016年7月16日下午11:41:26
 */
public class AnonymityInnerClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.function();
	}
}
/**
 * 
 * @ClassName:AbsDemo
 * @Description:抽象类
 * @author TOM
 * @Time: 2016年7月16日下午11:38:37
 */
abstract class AbsDemo {
	public abstract void show();

	public void method() {
		System.out.println("父类方法");
	}
}
/**
 * 
 * @ClassName:OuterClass
 * @Description:
 * @author TOM
 * @Time: 2016年7月16日下午11:41:02
 */
class OuterClass {

	public void function() {
		//相当于AbsDemo的子类,(子类以匿名内部类的方式重写了父类的方法)
		AbsDemo absDemo = new AbsDemo() {

			@Override
			public void show() {
				System.out.println("子类的show方法");
			}

			@Override
			public void method() {
				System.out.println("子类的method方法");
			}
		};
		absDemo.show();
		absDemo.method();
	}
}
