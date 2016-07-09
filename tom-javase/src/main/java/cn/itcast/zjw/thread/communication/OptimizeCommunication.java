package cn.itcast.zjw.thread.communication;

/** 
* @ClassName: OptimizeCommunication 
* @Description: 等待唤醒机制,需要多多理解
* @author Tom
* @date 2016-3-4 
*/ 
public class OptimizeCommunication {
	public static void main(String[] args) {
		OptimizeResource resource = new OptimizeResource();
		new Thread(new InputResource(resource)).start();
		new Thread(new OutputResource(resource)).start();
	}
}

class InputResource implements Runnable {
	OptimizeResource resource;

	public InputResource(OptimizeResource resource) {
		this.resource = resource;
	}

	public void run() {
		int x = 0;
		while (true) {
			synchronized (resource) {
				if (resource.isFlag()) {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					if (x == 0) {
						resource.setName("张三");
						resource.setSex("男");
					} else {
						resource.setName("丽丽");
						resource.setSex("女");
					}
					x = (x + 1) % 2;
					resource.setFlag(true);
					resource.notify();
				}
			}
		}
	}
}

class OutputResource implements Runnable {
	OptimizeResource resource;

	public OutputResource(OptimizeResource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			synchronized (resource) {
				if (!resource.isFlag()) {
					try {
						resource.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + "\t"
							+ resource.getName() + "\t" + resource.getSex());
					resource.setFlag(false);
					resource.notify();
				}
			}
		}
	}
}

class OptimizeResource {
	private String name;
	private String sex;
	private boolean flag = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
