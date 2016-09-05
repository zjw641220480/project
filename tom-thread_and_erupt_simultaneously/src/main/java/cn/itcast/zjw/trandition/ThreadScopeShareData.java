package cn.itcast.zjw.trandition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
	//private static int data = 0;
	private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
	public static void main(String[] args) {
		for(int i =0;i<2;i++){
			
			new Thread(new Runnable() {
				public void run() {
						int data = new Random().nextInt();
						System.out.println(Thread.currentThread().getName()+"\thas put data:\t"+data);
						threadData.put(Thread.currentThread(), data);
						new A().get();
						new B().get();
				}
			}).start();
		}
	}
	static class Lock{}
	static class A{
		
		public void get() {
			synchronized (Lock.class) {
				
				int dat = threadData.get(Thread.currentThread());
				System.out.println("A from"+Thread.currentThread().getName()+"\tget put data:\t"+dat);
			}
		}
	}
	static class B{
		public void get() {
			synchronized (Lock.class) {
				
				int data = threadData.get(Thread.currentThread());
				System.out.println("B from"+Thread.currentThread().getName()+"\tget put data:\t"+data);
			}
		}
	}
}
