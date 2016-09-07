package cn.itcast.zjw.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 线程pool-1-thread-1准备放入数据,当前队列中有2个数据
 * 线程pool-1-thread-2准备放入数据,当前队列中有2个数据
 * 上面两句话的解释:
 * 		两个线程共用一个BlockingQueue,当第一个线程放入数据后,此线程并没有直接就开始打印出当前队列中数据的个数
 * 	当第二个线程放入数据完成后,两个线程依次打印出来当前队列中的数据,那么必然就会是同一个值了;(两句话的原子性可以通过部分代码加写锁来保证)
 */
/**
 * 
 * @ClassName:BlockingQueueTest
 * @Description:
 * @Time:2016年9月7日
 * @author:Tom
 */
public class BlockingQueueTest {
	public static void main(String[] args) {
		final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		ExecutorService executorService = Executors.newCachedThreadPool();
		final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
		Runnable commandSet = null;
		for (int i = 0; i < 3; i++) {
			commandSet = new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep((long) (Math.random() * 1000));
							//要想保证它的原子性,需要加上写锁,读锁是不行的;
							lock.writeLock().lock();
							String threadName = Thread.currentThread().getName();
							blockingQueue.put(1);
							System.out.println("线程" + threadName + "准备放入数据,当前队列中有"+blockingQueue.size()+"个数据");
							System.out.println("线程" + threadName + "队列目前有" + blockingQueue.size() + "个数据");
							lock.writeLock().unlock();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			executorService.execute(commandSet);
		}
		Runnable commandGet = new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						String threadName = Thread.currentThread().getName();
						System.out.println("线程"+threadName + "准备取数据");
						blockingQueue.take();
						System.out.println("线程"+threadName + "已经取走数据,队列中目前有" + blockingQueue.size() + "个数据");
					} catch (Exception e) {
					}
				}
			}
		};
		executorService.execute(commandGet);
		executorService.shutdown();
	}
}

