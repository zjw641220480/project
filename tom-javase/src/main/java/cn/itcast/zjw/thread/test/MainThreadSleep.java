package cn.itcast.zjw.thread.test;

public class MainThreadSleep {
	private static int FLAG = 0;
	private static int FLAGB = 0;

	public static void main(String[] args) {
		MainThreadSleep testthread = new MainThreadSleep();
		int s = testthread.show();
		System.out.println("运行完整个程序后返回的值是:\t" + s);
	}

	public int show() {
		final int x = 0;
		System.out.println("Testthread.show()");
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("线程1");
				FLAG = 1;
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
		Runnable runnableB = new Runnable() {
			public void run() {
				System.out.println("主线程传递过来的name的值未:\t"+Thread.currentThread().getName());
				System.out.println("线程2");
				FLAGB = 2;
				//x=7;
			}
		};
		Thread threadB = new Thread(runnableB,"张三");
		threadB.start();
		
		System.out.println(FLAG + "现在的值");
		while (FLAG != 1 && FLAGB != 2) {
			System.out.println(FLAG + "循环中的值");
		}
		System.out.println("两个线程运行完成");
		return x;
	}
}
