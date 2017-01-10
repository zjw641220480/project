package cn.itcast.zjw.thread.communication;

/** 
* @ClassName: ProduceAndConsumer 
* @Description:多线程中生产者消费者的案例,这个也是需要多多思考分析的
* 对于多个生产者和消费者,为什么要定义while判断标记,
* 	原因:让被唤醒的线程再次	判断标记,以决定是否还应该继续执行,
* 为什么要定义成notifyAll()
* 	因为只需要唤醒对方线程,因为只用notify,容易出现只唤醒本方线程的情况,导致程序中的所有线程都等待,
* @author Tom
* @date 2016-3-5 
*/ 
public class ProduceAndConsumerSynchronized {
	public static void main(String[] args) {
		OperateResource resource = new OperateResource();
		//new Thread(new Producer(resource)).start();
		//new Thread(new Consumer(resource)).start();
		Thread threadA = new Thread(new Producer(resource));
		//Thread threadB = new Thread(new Producer(resource));
		Thread threadC = new Thread(new Consumer(resource));
		Thread threadD = new Thread(new Consumer(resource));
		threadA.start();
		//threadB.start();
		threadC.start();
		threadD.start();
	}
}

class OperateResource {
	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name) {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "---" + count++;
		System.out.println(Thread.currentThread().getName() + "...生产者"
				+ this.name);
		flag = true;
		this.notifyAll();
	}

	public synchronized void out() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "...消费者..."
				+ this.name);
		flag = false;
		this.notifyAll();
	}
}

class Producer implements Runnable {
	private OperateResource resource;

	public Producer(OperateResource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			resource.set("商品");
		}
	}
}

class Consumer implements Runnable {
	private OperateResource resource;

	public Consumer(OperateResource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			resource.out();
		}
	}
}
