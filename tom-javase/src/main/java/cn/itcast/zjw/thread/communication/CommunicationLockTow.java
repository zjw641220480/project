package cn.itcast.zjw.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.tom.util.logger.LoggerTypeEnum;
import org.tom.util.logger.LoggerUtil;

public class CommunicationLockTow {
	public static void main(String[] args) {
		CommunicationLockTow communicationLockTow = new CommunicationLockTow();
		ResourceLockTwo resourceTwo = new ResourceLockTwo();
		Thread threadA = new Thread(new InputLockTow(resourceTwo));
		Thread threadB = new Thread(new OutputLockTwo(resourceTwo));
		Thread threadC = new Thread(new OutputLockTwo(resourceTwo));
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
class InputLockTow implements Runnable{

	private ResourceLockTwo resourceTwo;

	public InputLockTow(ResourceLockTwo resource) {
		this.resourceTwo = resource;
	}

	public void run() {
		System.out.println("LockConsumer.run()");
		while (true) {
			resourceTwo.setResource();
		}
	}
	
}
class OutputLockTwo implements Runnable{
	private ResourceLockTwo resourceTwo;

	public OutputLockTwo(ResourceLockTwo resource) {
		this.resourceTwo = resource;
	}

	public void run() {
		System.out.println("LockConsumer.run()");
		while (true) {
			resourceTwo.getResource();
		}
	}
	
}
/**
 * 
 * @ClassName:ResourceLockTwo
 * @Description:在资源本身内部直接实现对资源的读写操作;
 * @Time:2017年2月24日
 * @author:Tom
 */
class ResourceLockTwo {
	private String name;
	private String sex;
	private boolean flag = false;
	//一把锁
	private Lock lock = new ReentrantLock();
	//两个类型的线程
	private Condition condition_Input  = lock.newCondition();
	private Condition condition_Output  = lock.newCondition();
	public void getResource(){
		lock.lock();
		try{
			while (!this.isFlag()) {
				// 锁对象的wait方法的替代
				System.out.println("OutputLock.getResource()");
				condition_Output.await();//生产者等待
			}
			System.out.println(this.getName() + "\t"
					+ this.getSex());
			this.setFlag(false);
			condition_Input.signal();
		}catch(Exception e){
			LoggerUtil.writeToLogger(OutputLock.class, LoggerTypeEnum.ERROR, "线程在执行的时候出现错误");
		}finally{
			lock.unlock();
		}
	}
	int x=0;
	public void setResource(){
		lock.lock();
		
		try{
			while (this.isFlag()) {
				// 锁对象的wait方法的替代
				System.out.println("InputLock.setResource()");
				condition_Input.await();//生产者等待
			}
			if (x == 0) {
				this.setName("张三");
				this.setSex("男");
			} else {
				this.setName("丽丽");
				this.setSex("女");
			}
			x = (x + 1) % 2;
			System.out.println("生产完成.....");
			this.setFlag(true);
			condition_Output.signal();
		}catch(Exception e){
			LoggerUtil.writeToLogger(OutputLock.class, LoggerTypeEnum.ERROR, "线程在执行的时候出现错误");
		}finally{
			lock.unlock();
		}
	}
	
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
