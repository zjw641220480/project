package cn.itcast.zjw.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @ClassName:ThreadPoolTest
 * @Description:对线程池的测试
 * @Time:2016年9月6日
 * @author:Tom
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		//固定大小的线程池
		//ExecutorService executorService = Executors.newFixedThreadPool(5);
		//具有缓冲大小的线程池
		//ExecutorService executorService = Executors.newCachedThreadPool();
		//创建单一线程的线程池
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//具有定时效果的线程池
		//ExecutorService executorService = Executors.newScheduledThreadPool(3);
		for(int i=0;i<10;i++){
			final int task = i;
			//为什么只有三个线程,因为Runnable中只是存放了线程运行的代码(线程任务),而不是线程!!!!!
			//线程是有Thread通过start方法来启动的,(线程运行的原理)
			executorService.execute(new Runnable() {
				public void run() {
					for(int j=0;j<3;j++){
						System.out.println("此时运行线程名称:"+Thread.currentThread().getName()+"\t\texecute\t"+j+"\t"+task);
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		//这个方法会把池子中的所有线程全部销毁;
		//executorService.shutdown();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadPoolTest.main()===============");
		for(int i=0;i<3;i++){
			final int task = i;
			//为什么只有三个线程,因为Runnable中只是存放了线程运行的代码,而不是线程!!!!!
			//线程是有Thread通过start方法来启动的,(线程运行的原理)
			executorService.execute(new Runnable() {
				public void run() {
					for(int j=0;j<3;j++){
						System.out.println("此时运行线程名称:"+Thread.currentThread().getName()+"\t\texecute\t"+j+"\t"+task);
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
}
