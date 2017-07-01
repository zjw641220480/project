package cn.itcast.zjw.trandition;

import java.util.Random;

import cn.itcast.zjw.domain.Person;

/**
 * 
 * <p>Titile:ThreadLocalPersonTest</p>
 * <p>Description:以当前线程为锁,获取自己线程中保存的相关数据  </p>
 * @author TOM
 * @date 2017年7月1日 下午12:09:27
 */
public class ThreadLocalPersonTest {
	public static void main(String[] args) {
		for(int i = 0;i<3;i++){
			new Thread(new Runnable() {
				public void run() {
					int age = new Random().nextInt();
					Person person = Person.getInstance();
					person.setAge(String.valueOf(age));
					System.out.println(Thread.currentThread().getName()+"\thas put age to ThreadLocal:\t"+age);
					new A().printPersonAge();
					new B().printPersonAge();
					person.clear();
				}
			}).start();
		}
	}
	static class A{
		public void printPersonAge(){
			Person person = Person.getInstance();
			System.out.println("A class \t"+Thread.currentThread().getName()+"get Data:\t"+person.getAge());
		}
	}
	static class B{
		public void printPersonAge(){
			Person person = Person.getInstance();
			System.out.println("B class \t"+Thread.currentThread().getName()+"get Data:\t"+person.getAge());
		}
	}
}
