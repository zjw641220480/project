package cn.itcast.zjw.thread.stop;

/** 
* @ClassName: StopThread 
* @Description:如何停止线程,只有一种,那就是run方法运行结束
* 开启多线程运行,运行代码通常是循环结构,只要控制了循环,就可以让run方法结束,也就是线程结束,
* 当线程处于了冻结状态就不会读取到标记,那么线程就不会结束,
* 当没有指定的方式让冻结的线程恢复到运行状态的时候,这时需要对冻结的线程进行清除,强制让线程恢复到运行状态中来,这样就可以操作标记,让线程结束,
* Thread中提供了interrupt方法来达到此目的;
* @author Tom
* @date 2016-3-5 
*/ 
public class StopThread {
	public static void main(String[] args) {
		StopDemo demo = new StopDemo();
		Thread threadA = new Thread(demo);
		Thread threadB = new Thread(demo);
		threadA.start();
		threadB.start();
		
		int num = 0 ;
		while(true){
			if(num++==69){
				threadA.interrupt();
				threadB.interrupt();
				demo.changeFlag(false);
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......main\t"+num);
		}
	}
}
class StopDemo implements Runnable{
	private boolean flag = true;
	private int num = 0;
	public synchronized void run() {
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName()+"......run\t"+num++);
		}
	}
	
	public void changeFlag(boolean flag){
		this.flag = flag;
	}
}