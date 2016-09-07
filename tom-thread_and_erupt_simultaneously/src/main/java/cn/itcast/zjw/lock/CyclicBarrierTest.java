package cn.itcast.zjw.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final CyclicBarrier barrier = new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						long time = (long) (Math.random()*10000);
						Thread.sleep(time);
						System.out.println("此线程等待了\t"+time);
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点1,当前已有"+(barrier.getNumberWaiting()+1));
						barrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						long time = (long) (Math.random()*1000);
						Thread.sleep(time);
						System.out.println("此线程等待了\t"+time);
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点2,当前已有"+(barrier.getNumberWaiting()+1));
						barrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						long time = (long) (Math.random()*1000);
						Thread.sleep(time);
						System.out.println("此线程等待了\t"+time);
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合地点3,当前已有"+(barrier.getNumberWaiting()+1));
						barrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
