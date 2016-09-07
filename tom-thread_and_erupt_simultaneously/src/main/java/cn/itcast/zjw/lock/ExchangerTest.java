package cn.itcast.zjw.lock;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * @ClassName:ExchangerTest
 * @Description:两个线程之间数据的交换
 * @Time:2016年9月7日
 * @author:Tom
 */
public class ExchangerTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		executorService.execute(new Runnable() {
			public void run() {
				try {
					String data1 = "线程1的数据";
					String data2 = null;
					String threadName = Thread.currentThread().getName();
					System.out.println("线程" + threadName + "正在把数据\t" + data1 + "\t交换出去");
					Thread.sleep((long) (Math.random()*1000));
					data2 = exchanger.exchange(data1);
					System.out.println("线程" + threadName + "换回的数据为\t" + data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		executorService.execute(new Runnable() {
			public void run() {
				try {
					String data21 = "线程2的数据";
					String data22 = null;
					String threadName = Thread.currentThread().getName();
					System.out.println("线程" + threadName + "正在把数据\t" + data21 + "\t交换出去");
					Thread.sleep((long) (Math.random()*1000));
					data22 = exchanger.exchange(data21);
					System.out.println("线程" + threadName + "换回的数据为\t" + data22);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		executorService.shutdown();
	}
}
