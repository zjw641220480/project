package cn.itcast.zjw.thread.test;

/**
 * 主线程和其他两个线程交替运行
 * @author Administrator
 *
 */
public class TestAlternate {
	public static void main(String[] args) {
		MyAlternateThread alternateThreadA = new MyAlternateThread("线程A");
		MyAlternateThread alternateThreadB = new MyAlternateThread("线程B");
		alternateThreadA.start();
		alternateThreadB.start();
		for(int i=0;i<60;i++){
			System.out.println("main()\t"+i);
		}
		System.out.println("TestAlternate.main()");
		MyThreadName threadName = new MyThreadName("自己定义的线程名称");
		threadName.start();
	}
}	
class MyAlternateThread extends Thread{
	private String name;
	
	public MyAlternateThread(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		for(int i=0;i<60;i++){
			System.out.println("run()\t"+this.name+i);
		}
	}
}
class MyThreadName extends Thread{
	public MyThreadName(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<60;i++){
			System.out.println("MyThreadName.run()"+Thread.currentThread().getName());
			System.out.println("run()\t"+this.getName()+i);
		}
	}
}
