package cn.itcast.zjw.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MyTest {
	final static Semaphore semaphore = new Semaphore(2);
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i=0;i<2;i++){
			Runnable runnable = new Runnable() {
				String name = null;
				public void run() {
					try {
						semaphore.acquire();
						name = Thread.currentThread().getName();
						System.out.println("线程"+Thread.currentThread().getName()+"获得信号灯");
						System.out.println(name+"当前可用信号灯:"+semaphore.availablePermits());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name+"信号灯即将释放");
					semaphore.release();
					System.out.println(name+"信号灯释放完毕,当前可用信号灯:\t"+semaphore.availablePermits());
					
				}
				
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
