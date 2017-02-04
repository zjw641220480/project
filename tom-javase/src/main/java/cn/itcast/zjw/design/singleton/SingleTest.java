package cn.itcast.zjw.design.singleton;

public class SingleTest {
	public static void main(String[] args) {
		Singleton singleton1 = SingletonHungryOptimize.getInstance();
		Singleton singleton2 = SingletonHungryOptimize.getInstance();
		//Singleton类的构造方法只会运行一次;
		System.out.println(singleton1);
		System.out.println(singleton2);
		System.out.println(singleton1==singleton2);
	}
}
