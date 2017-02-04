package cn.itcast.zjw.thread.createthread;

public class ThreadRunnable implements Runnable{

	public void run() {
		System.out.println(this.toString());
		System.out.println("实现Runnable接口方式的线程运行:---ThreadRunnable.run()");
		System.out.println(Thread.currentThread().getName());
	}
	/**
	 * 
	 * @MethodName:main
	 * @Description:测试实现Runnable接口方式的
	 * @param args
	 * @Time:2016年9月5日下午11:50:35
	 * @author:Tom
	 */
	public static void main(String[] args) {
		Thread threadA = new Thread(new ThreadRunnable());
		threadA.start();
		System.out.println(Thread.currentThread().getName());
	}
}
