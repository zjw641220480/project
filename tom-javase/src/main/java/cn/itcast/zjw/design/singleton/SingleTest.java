package cn.itcast.zjw.design.singleton;

public class SingleTest {
	public static void main(String[] args) {
		Singleton singleton1 = SingletonHungryOptimize.getInstance();
		Singleton singleton2 = SingletonHungryOptimize.getInstance();
		System.out.println(singleton1==singleton2);
	}
}
