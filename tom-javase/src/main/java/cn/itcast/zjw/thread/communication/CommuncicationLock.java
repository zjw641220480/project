package cn.itcast.zjw.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;
import org.tom.util.logger.LoggerTypeEnum;
import org.tom.util.logger.LoggerUtil;

public class CommuncicationLock {
	//使用Junit来测试线程的时候是容易出错的;
	@Test
	public void testCommuncicationLockResource(){
		//一份资源
		ResourceLock resourceLock = new ResourceLock();
		//一把锁
		Lock lock = new ReentrantLock();
		//两个类型的线程
		Condition condition_Output = lock.newCondition();
		Condition condition_Input = lock.newCondition();
		Thread threadOutputA = new Thread(new InputLock(resourceLock, lock, condition_Output, condition_Input));
		Thread threadOutputB = new Thread(new OutputLock(resourceLock, lock, condition_Output, condition_Input));
		threadOutputA.start();
		threadOutputB.start();
	}
	public static void main(String[] args) {
		//一份资源
		ResourceLock resourceLock = new ResourceLock();
		//一把锁
		Lock lock = new ReentrantLock();
		//两个类型的线程
		Condition condition_Output = lock.newCondition();
		Condition condition_Input = lock.newCondition();
		Thread threadInputA = new Thread(new InputLock(resourceLock, lock, condition_Output, condition_Input));
		Thread threadOutputA = new Thread(new OutputLock(resourceLock, lock, condition_Output, condition_Input));
		Thread threadOutputB = new Thread(new OutputLock(resourceLock, lock, condition_Output, condition_Input));
		threadInputA.start();
		threadOutputA.start();
		threadOutputB.start();
	}
}
class InputLock implements Runnable{
	//操作同一份资源
	private ResourceLock resourceLock;
	//两个线程在同一个锁的范围内
	private Lock lock;//= new ReentrantLock();
	private Condition condition_Output;
	private Condition condition_Input;//  = lock.newCondition();
	public InputLock(ResourceLock resourceLock,Lock lock,Condition condition_Output,Condition condition_Input) {
		this.resourceLock = resourceLock;
		this.lock = lock;
		this.condition_Input = condition_Input;
		this.condition_Output = condition_Output;
	}

	public void run() {
		while(true){
			this.setResource();
		}
	}
	private int x=0;
	private void setResource(){
		lock.lock();
		try{
			while (resourceLock.isFlag()) {
				// 锁对象的wait方法的替代
				System.out.println("InputLock.setResource()+++++++++");
				condition_Input.await();//生产者等待
			}
			if (x == 0) {
				this.resourceLock.setName("张三");
				this.resourceLock.setSex("男");
			} else {
				this.resourceLock.setName("丽丽");
				this.resourceLock.setSex("女");
			}
			x = (x + 1) % 2;
			System.out.println("生产完成.....");
			resourceLock.setFlag(true);
			condition_Output.signal();
		}catch(Exception e){
			LoggerUtil.writeToLogger(OutputLock.class, LoggerTypeEnum.ERROR, "线程在执行的时候出现错误");
		}finally{
			lock.unlock();
		}
	}
}
class OutputLock implements Runnable{
	private ResourceLock resourceLock;
	private Lock lock;
	private Condition condition_Output;// = lock.newCondition();
	private Condition condition_Input;
	public OutputLock(ResourceLock resourceLock,Lock lock,Condition condition_Output,Condition condition_Input) {
		this.resourceLock = resourceLock;
		this.lock = lock;
		this.condition_Input = condition_Input;
		this.condition_Output = condition_Output;
	}

	public void run() {
		while(true){
			this.getResource();
		}
	}
	public void getResource(){
		lock.lock();
		try{
			while (!resourceLock.isFlag()) {
				// 锁对象的wait方法的替代
				System.out.println("OutputLock.getResource()================");
				condition_Output.await();//生产者等待
			}
			System.out.println(this.resourceLock.getName() + "\t"
					+ this.resourceLock.getSex());
			resourceLock.setFlag(false);
			condition_Input.signal();
		}catch(Exception e){
			LoggerUtil.writeToLogger(OutputLock.class, LoggerTypeEnum.ERROR, "线程在执行的时候出现错误");
		}finally{
			lock.unlock();
		}
	}
}
/**
 * 
 * @ClassName:ResourceLock
 * @Description:使用JDK1.5新版本特性中的Lock形式的资源
 * @author TOM
 * @Time: 2016年7月18日下午9:23:06
 */
class ResourceLock {
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