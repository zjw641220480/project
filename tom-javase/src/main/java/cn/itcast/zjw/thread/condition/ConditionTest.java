package cn.itcast.zjw.thread.condition;

public class ConditionTest {
	private static BoundedBuffer bb = new BoundedBuffer();

    public static void main(String[] args) {
        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i=0; i<9; i++) {
        	new TakeThread("t"+i).start();
        	new PutThread("p"+i, i).start();
        }
    }
    /**
     * 
     * <p>Titile:PutThread</p>
     * <p>Description:向缓存放入数据的线程类 </p>
     * @author TOM
     * @date 2017年7月30日 下午5:00:30
     */
    static class PutThread extends Thread {
        private int num;
        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }
        public void run() {
            try {
                Thread.sleep(1);    // 线程休眠1ms
                bb.put(num);        // 向BoundedBuffer中写入数据
            } catch (InterruptedException e) {
            }
        }
    }
    
    /**
     * 
     * <p>Titile:TakeThread</p>
     * <p>Description:从缓存拿取数据的线程类 </p>
     * @author TOM
     * @date 2017年7月30日 下午5:00:53
     */
    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }
        public void run() {
            try {
                Thread.sleep(10);                    // 线程休眠1ms
                Integer num = (Integer)bb.take();    // 从BoundedBuffer中取出数据
            } catch (InterruptedException e) {
            }
        }
    }
}
