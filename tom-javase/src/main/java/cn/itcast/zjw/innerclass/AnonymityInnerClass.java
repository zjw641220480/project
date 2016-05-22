package cn.itcast.zjw.innerclass;

public class AnonymityInnerClass {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.function();
	}
}

abstract class AbsDemo {
	public abstract void show();

	public void method() {
		System.out.println("父类方法");
	}
}

class OuterClass {
	int x = 3;

	/*
	 * class Inner extends AbsDemo { public void show() {
	 * System.out.println("内部类打印外部类中的变量:\t" + x); } }
	 */

	public void function() {
		// new Inner().show();
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
