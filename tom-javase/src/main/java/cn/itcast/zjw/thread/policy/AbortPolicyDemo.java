package cn.itcast.zjw.thread.policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Titile:AbortPolicyDemo</p>
 * <p>Description: AbortPolicy策略</p>
 * @author TOM
 * @date 2017年7月31日 下午5:37:58
 */
public class AbortPolicyDemo {
	private static final int THREADS_SIZE = 1;
	private static final int CAPACITY = 1;
	/**
	 * 
	 * @MethodName:main
	 * @Description:这种策略下,首先看线程池是否还能再接收新的线程,不能了之后,查看能否放入到阻塞队列中,若队列也满了,直接报错,但是已经在运行的线程,以及在阻塞队列中的线程会执行完毕,后面再来的线程都不会再执行了;
	 * @param args
	 * @throws Exception
	 * @Time: 2017年7月31日 下午5:38:12
	 * @author: TOM
	 */
	public static void main(String[] args) throws Exception {

		// 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(CAPACITY));
		// 设置线程池的拒绝策略为"抛出异常"
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

		try {

			// 新建10个任务，并将它们添加到线程池中。
			for (int i = 0; i < 10; i++) {
				Runnable myrun = new MyRunnable("task-" + i);
				pool.execute(myrun);
			}
		} catch (RejectedExecutionException e) {
			e.printStackTrace();
			// 关闭线程池
			pool.shutdown();
		}
	}
}

class MyRunnable implements Runnable {
	private String name;

	public MyRunnable(String name) {
		this.name = name;
	}

	public void run() {
		try {
			System.out.println(this.name + " is running.");
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}