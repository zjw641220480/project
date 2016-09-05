package cn.itcast.zjw.trandition;

import java.util.Random;

import org.junit.Test;

import cn.itcast.zjw.domain.Person;
/**
 * 
 * @ClassName:ThreadLocalTest
 * @Description:对ThreadLocal类的测试
 * @Time:2016年9月5日
 * @author:Tom
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	private static ThreadLocal<Person> threadLocalPerson = new ThreadLocal<Person>();
	/**
	 * 
	 * @MethodName:main
	 * @Description:多线程共享数据,
	 * @param args
	 * @Time:2016年9月5日下午3:48:59
	 * @author:Tom
	 */
	public static void main(String[] args) {
		for(int i = 0;i<3;i++){
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+"has put data:\t"+data);
					threadLocal.set(data);
					new A().getData();
					new B().getData();
					
					/*Person person = new Person();
					person.setAge(String.valueOf(data));
					threadLocalPerson.set(person);
					new A().getPerson();
					new B().getPerson();*/
					Person.getInstance().setAge(String.valueOf(data));
					new A().getPerson();
					new B().getPerson();
				}
			}).start();
			/*if(i==1){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		}
	}
	static class A{
		public void getData(){
			int data = threadLocal.get();
			System.out.println("A Class from\t"+Thread.currentThread().getName()+"\t"+data);
		}
		public void getPerson(){
			Person person = threadLocalPerson.get();
			System.out.println("A Class Get Person Property from\t"+Thread.currentThread().getName()+"\t"+person.getAge());
		}
	}
	static class B{
		public void getData(){
			int data = threadLocal.get();
			System.out.println("B Class from\t"+Thread.currentThread().getName()+"\t"+data);
		}
		public void getPerson(){
			Person person = threadLocalPerson.get();
			System.out.println("B Class Get Person Property from\t"+Thread.currentThread().getName()+"\t"+person.getAge());
		}
	}
}

