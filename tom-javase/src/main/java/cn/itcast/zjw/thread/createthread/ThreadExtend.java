package cn.itcast.zjw.thread.createthread;

/** 
* @ClassName: ThreadExtend 
* @Description:使用继承的方式来创建线程
* 创建线程的步骤:
* 	定义类继承Thread
* 	重写Thread中的run方法
* 	调用线程的start方法,
* @author Tom
* @date 2016-3-3 
*/ 
public class ThreadExtend extends Thread{

	@Override
	public void run() {
		System.out.println("继承方式的线程运行---ThreadExtend.run()");
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadExtend threadExtend = new ThreadExtend();
		threadExtend.start();
	}
}
