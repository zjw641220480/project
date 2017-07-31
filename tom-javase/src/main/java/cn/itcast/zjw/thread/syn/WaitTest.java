package cn.itcast.zjw.thread.syn;

class ThreadA extends Thread{

    public ThreadA(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            //notifyAll();
        	while(true){
        		try {
        			System.out.println("------------");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
    }
}

public class WaitTest {

    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");

        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName()+" start t1");
                t1.start();
                //主线程虽然在睡眠,但是依旧在拿着锁;
                //Thread.currentThread().sleep(8000);
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName()+" wait()");
                //下面wait方法运行的时候,主线程才将锁释放掉;
                //设置时间的时候,上面的run方法中不要再有锁判断,不然,其不会讲锁释放了;
                t1.wait(3000);

                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}