package cn.itcast.zjw.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	public static void main(String[] args) {
		ExecutorService executorService =Executors.newSingleThreadExecutor();
		Future<Object> future =
			executorService.submit(new Callable<Object>() {
				public Object call() throws Exception {
					System.out.println(Thread.currentThread().getName());
					return "submit111111";
				}
			});
		
		try {
			System.out.println(Thread.currentThread().getName()+"\t"+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
