package cn.itcast.zjw.thread.policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Titile:DiscardPolicyDemo</p>
 * <p>Description: DiscardPolicy类型对的拒绝策略</p>
 * @author TOM
 * @date 2017年7月31日 下午3:59:44
 */
public class DiscardPolicyDemo {
	private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;
    /**
     * 
     * @MethodName:main
     * @Description:这种策略下,首先看线程池是否还能再接收新的线程,不能了,看阻塞队列中是否还可以放入,可以的话,放入,等待执行,不能的话(队列满了),就只能丢掉了;且不报错;
     * @param args
     * @throws Exception
     * @Time: 2017年7月31日 下午5:24:13
     * @author: TOM
     */
    public static void main(String[] args) throws Exception {
    	//线程池中共运行了2个任务。第1个任务直接放到Worker中，通过线程去执行；第2个任务放到阻塞队列中等待,运行的线程一直的0,1线程
    	
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1));
        // 设置线程池的拒绝策略为"丢弃"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 10; i++) {
            Runnable myrun = new MyRunnableDiscardOld("task-"+i);
            pool.execute(myrun);
        }
        // 关闭线程池
        pool.shutdown();
    }
}

class MyRunnableDiscard implements Runnable {
    private String name;
    public MyRunnableDiscard(String name) {
        this.name = name;
    }
    
    public void run() {
        try {
            System.out.println(this.name + " is running.");
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
