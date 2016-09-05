package cn.itcast.zjw.thread.createthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCallable implements Callable<Object>{

	public Object call() throws Exception {
		System.out.println(this.toString());
		System.out.println("实现Callable接口方式的线程运行:---ThreadCallable.call()");
		System.out.println(Thread.currentThread().getName());
		return new String("Callable中call方法的返回值");
	}
	/**
	 * 
	 * @MethodName:main
	 * @Description:实现Callable接口方式的线程测试,同时使用到了线程池
	 * @param args
	 * @Time:2016年9月5日下午11:54:10
	 * @author:Tom
	 */
	public static void main(String[] args) {
		ThreadCallable threadCallableA = new ThreadCallable();
		ThreadCallable threadCallableB = new ThreadCallable();
		List<ThreadCallable>  threadCallables = new ArrayList<ThreadCallable>();
		threadCallables.add(threadCallableA);
		threadCallables.add(threadCallableB);
		//ExecutorService对象运行的是一个线程池中的所有方法,
		//下面这句话是初始化一个线程池;
		ExecutorService executor = Executors.newFixedThreadPool(4);
		try {
			executor.invokeAll(threadCallables);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//断言线程池中线程全部运行结束
		executor.shutdown();
		//下面这句主线程的输出语句一定会是在所有线程运行结束之后才会进行输出打印
		System.out.println("所有线程均已经运行结束");
	}
}
