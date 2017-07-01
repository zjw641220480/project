package cn.itcast.zjw.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final CountDownLatch countDownLatchOrder = new CountDownLatch(1);
		final CountDownLatch countDownLatchAnser = new CountDownLatch(3);
		/**
		 * 这三个线程相当于三个运动员的角色;
		 */
		for(int i = 0;i<3;i++){
			Runnable command = new Runnable() {
				public void run() {
					try {
						System.out.println("线程"+Thread.currentThread().getName()+"正在准备接受命令");
						//等待裁判发布命令,
						System.out.println(countDownLatchAnser.getCount());
						countDownLatchOrder.await();
						System.out.println("线程"+Thread.currentThread().getName()+"已经接受命令");
						Thread.sleep((long) (Math.random()*1000));
						System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果");
						//运动员回应处理结果
						countDownLatchAnser.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(command);
		}
		/**
		 * 主线程相当于裁判的角色
		 */
		try {
			Thread.sleep((long) (Math.random()*1000));
			String threadName = Thread.currentThread().getName();
			System.out.println("线程"+threadName+"即将发布命令");
			//裁判发布命令
			countDownLatchOrder.countDown();
			System.out.println("线程"+threadName+"以发送命令,正在等待结果");
			//裁判等待所有运动员的回应结果
			countDownLatchAnser.await();
			System.out.println("线程"+threadName+"以收到所有响应结果");
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
