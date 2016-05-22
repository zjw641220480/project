package cn.itcast.zjw.thread.communication;

/**
 * @ClassName: Communication
 * @Description:一个用来写入数据,一个用来读取数据,两个之间加锁的时候,使用操作的那同一份资源来作为锁是最恰当的;
 * wait(),notify(),notifyAll()都使用在同步中,因为要对持有监视器的线程进行操作,所以要使用在同步中,因为只有同步才具有锁,
 * 为什么这些操作线程的方法要定义在Object中?
 * 		因为这些方法在操作同步中线程时候,都必须要标识他们所操作线程持有的锁,只有同一个锁上的被等待线程,可以被同一个锁上的notify唤醒,
 * 不可以对不同锁中的线程进行唤醒,也就是说,等待和唤醒必须是同一把锁,而锁可以是任意对象,所以可以被任意对象调用的方法定义在Object中,
 * @author Tom
 * @date 2016-3-4
 */
public class Communication {
	//线程间通讯
	public static void main(String[] args) {
		Resource resource = new Resource();
		Input input = new Input(resource);
		Output output = new Output(resource);

		Thread threadIn = new Thread(input);
		Thread threadOut = new Thread(output);

		threadIn.start();
		threadOut.start();
	}
}

/**
 * @ClassName: Input
 * @Description:写入数据
 * @author Tom
 * @date 2016-3-4
 */
class Input implements Runnable {
	Resource resource;
	//要操作的是同一个资源,所以把资源作为锁,同时在多个线程中,直接把资源传递进来以便使得多个线程操作的是同一份资源
	Input(Resource resource) {
		this.resource = resource;
	}
	public void run() {
		int x = 0;
		while (true) {
			synchronized (resource) {
				if (resource.flag) {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x == 0) {
					this.resource.name = "张三";
					this.resource.sex = "男";
				} else {
					this.resource.name = "丽丽";
					this.resource.sex = "女";
				}
				x = (x + 1) % 2;
				resource.flag = true;
				resource.notify();
			}
		}
	}
}

/**
 * @ClassName: Output
 * @Description:取出数据
 * @author Tom
 * @date 2016-3-4
 */
class Output implements Runnable {
	Resource resource;

	public Output(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			synchronized (resource) {
				if (!resource.flag) {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(this.resource.name + "\t"
						+ this.resource.sex);
				resource.flag = false;
				resource.notify();
			}
		}
	}
}

/**
 * @ClassName: Resource
 * @Description: 操作的那个同一份资源
 * @author Tom
 * @date 2016-3-4
 */
class Resource {
	String name;
	String sex;
	boolean flag = false;
}