package cn.itcast.zjw.thread.createthread;

import org.junit.Test;

public class ThreadRunnable implements Runnable{

	public void run() {
		System.out.println(this.toString());
		System.out.println("ThreadRunnable.run()");
		System.out.println(Thread.currentThread().getName());
	}
	/**
	 * 
	 * @Method:testThreadRunnable
	 * @Description:测试实现Runnable接口方式的
	 * @author TOM
	 * @date 2016年7月18日
	 */
	@Test
	public void testThreadRunnable(){
		Thread threadA = new Thread(new ThreadRunnable());
		Thread threadB = new Thread(new ThreadRunnable());
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName()+"\t测试主线程");
	}
}
