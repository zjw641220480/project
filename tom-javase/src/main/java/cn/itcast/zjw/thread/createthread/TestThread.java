package cn.itcast.zjw.thread.createthread;

/** 
* @ClassName: TestThread 
* @Description:继承方式创建线程的小例子
* static currentThread():获取当前线程对象,
* getName();获取线程的名字
* 设置线程:setName()或者构造方法
* @author Tom
* @date 2016-3-3 
*/ 
public class TestThread {
	public static void main(String[] args) {
		TestA threadA = new TestA();
		TestA threadB = new TestA();
		threadA.start();
		threadB.start();
		
		for(int x = 0;x<60;x++){
			System.out.println("TestThread.main()...\t"+x);
		}
	}
}
class TestA extends Thread{
	/*用来获取线程的名字,这个是自定义方式,
	private String name;
	public TestA(String name){
		this.name = name;
	}*/
	@Override
	public void run() {
		for(int x=0;x<60;x++){
			System.out.println((Thread.currentThread()==this)+"..."+this.getName() + "test run...\t"+x);
		}
	}
}
