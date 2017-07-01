package cn.itcast.zjw.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * <p>Titile:CyclicBarrierTest</p>
 * <p>Description: 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。</p>
 * @author TOM
 * @date 2017年7月1日 下午2:39:13
 */
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
