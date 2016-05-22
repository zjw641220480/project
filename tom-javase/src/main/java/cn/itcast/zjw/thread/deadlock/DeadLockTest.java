package cn.itcast.zjw.thread.deadlock;

/**
 * @ClassName: DeadLockTest
 * @Description:一个简单的死锁的案例
 * @author Tom
 * @date 2016-3-4
 */
public class DeadLockTest {
	public static void main(String[] args) {
		Test testA = new Test(true);
		Test testB = new Test(false);
		Thread threadA = new Thread(testA);
		Thread threadB = new Thread(testB);
		threadA.start();
		threadB.start();
	}
}

class MyLock {
	static Object locka = new Object();
	static Object lockb = new Object();
}

class Test implements Runnable {
	private boolean flag;

	Test(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		if (flag) {
			//A锁之中嵌套B锁
			synchronized (MyLock.locka) {
				System.out.println("if Locka");
				synchronized (MyLock.lockb) {
					System.out.println("if lockb");
				}
			}
		} else {
			//B锁之中嵌套A锁
			synchronized (MyLock.lockb) {
				System.out.println("else locka");
				synchronized (MyLock.locka) {
					System.out.println("else lockb");
				}
			}
		}
	}
}