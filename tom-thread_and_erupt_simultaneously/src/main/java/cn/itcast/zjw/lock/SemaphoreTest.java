package cn.itcast.zjw.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 
 * @ClassName:SemaphoreTest
 * @Description:线程中的信号灯,这个一直存在问题;
 * @Time:2016年9月6日
 * @author:Tom
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		final Semaphore semaphore = new Semaphore(3);
		for(int i=0;i<10;i++){
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("线程"+Thread.currentThread().getName()+"进入,当前已有\t"+(semaphore.drainPermits()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
					semaphore.release();
					//下面代码有时候会执行不准确,因为没有和上面代码合成原子
					System.out.println("线程"+Thread.currentThread().getName()+"已离开,当前可以再添加\t"+semaphore.availablePermits()+"个并发");
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}