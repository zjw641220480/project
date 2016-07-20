package cn.itcast.zjw.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 加锁,解锁,中间过程中判断被哪个锁所管理的线程等待,被哪个锁所管理的线程起来;
 */
/** 
* @ClassName: ProduceAndConsumLock 
* @Description:jdk1.5版本后出现的新特性,Lock,Condition
* 将同步synchronized替换成了显示的Lock
* 将Object中的wait,notify,notifyAll替换为了Condition
* 该对象可以通过锁Lock来创建,
* 在该事例中实现了本方只唤醒对方的操作,
* @author Tom
* @date 2016-3-5 
*/ 
// 这一个类需要着重去看,并且好好理解;
public class ProduceAndConsumLock {
	public static void main(String[] args) {
		System.out.println("ProduceAndConsumLock.main()");
		LockResource resource = new LockResource();
		Thread threadA = new Thread(new LockProducer(resource));
		Thread threadB = new Thread(new LockProducer(resource));
		Thread threadC = new Thread(new LockConsumer(resource));
		Thread threadD = new Thread(new LockConsumer(resource));
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
		System.out.println("ProduceAndConsumLock.main()");
	}
}

class LockResource {
	private String name;
	private int count = 1;
	private boolean flag = false;
	//同一个锁中的线程,才能被唤醒
	private Lock lock = new ReentrantLock();
	private Condition condition_Pro  = lock.newCondition();
	private Condition condition_Con  = lock.newCondition();
	public void set(String name) {
		lock.lock();// 加锁,和以前的synchronized差不多
		try {
			while (flag) {
				// 锁对象的wait方法的替代
				System.out.println("LockResource.set()");
				condition_Pro.await();//生产者等待
			}
			this.name = name + "---" + count++;
			System.out.println(Thread.currentThread().getName() + "...生产者"
					+ this.name);
			flag = true;
			// 唤醒另外一个线程,相当于原来锁对象的notify方法;
			condition_Con.signal();//唤醒的是消费者
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放锁的对象一定要执行
			lock.unlock();// 解锁,和以前的synchronized差不多
		}

	}

	public void out() {
		lock.lock();
		try {
			while (!flag) {
				System.out.println("LockResource.out()");
				condition_Con.await();
			}
			System.out.println(Thread.currentThread().getName() + "...消费者..."
					+ this.name);
			flag = false;
			condition_Pro.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class LockProducer implements Runnable {
	private LockResource resource;

	public LockProducer(LockResource resource) {
		this.resource = resource;
	}

	public void run() {
		System.out.println("LockProducer.run()");
		while (true) {
			resource.set("商品");
		}
	}
}

class LockConsumer implements Runnable {
	private LockResource resource;

	public LockConsumer(LockResource resource) {
		this.resource = resource;
	}

	public void run() {
		System.out.println("LockConsumer.run()");
		while (true) {
			resource.out();
		}
	}
}
