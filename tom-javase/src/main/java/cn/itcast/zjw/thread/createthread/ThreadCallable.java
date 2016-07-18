package cn.itcast.zjw.thread.createthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import cn.itcast.zjw.thread.callable.product.CallableProduct;

public class ThreadCallable implements Callable<Object>{

	public Object call() throws Exception {
		System.out.println(this.toString());
		System.out.println("ThreadCallable.call()");
		System.out.println(Thread.currentThread().getName());
		return new String("Callable中call方法的返回值");
	}
	@Test
	public void testThreadCallable() throws InterruptedException{
		ThreadCallable threadCallableA = new ThreadCallable();
		ThreadCallable threadCallableB = new ThreadCallable();
		List<ThreadCallable>  threadCallables = new ArrayList<ThreadCallable>();
		threadCallables.add(threadCallableA);
		threadCallables.add(threadCallableB);
		//ExecutorService对象运行的是一个线程池中的所有方法,
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.invokeAll(threadCallables);
		//断言线程池中线程全部运行结束
		executor.shutdown();
		System.out.println("所有线程均已经运行结束");
	}
}
