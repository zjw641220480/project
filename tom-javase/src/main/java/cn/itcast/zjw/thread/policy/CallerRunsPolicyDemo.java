package cn.itcast.zjw.thread.policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Titile:CallerRunsPolicyDemo</p>
 * <p>Description: CallerRunsPolicy策略</p>
 * @author TOM
 * @date 2017年7月31日 下午5:39:57
 */
public class CallerRunsPolicyDemo {
	private static final int THREADS_SIZE = 1;
	private static final int CAPACITY = 1;
	/**
	 * 
	 * @MethodName:main
	 * @Description:此种方式每一个提交的任务都会被执行完毕,有线程可以执行,那么直接执行,没有线程执行的时候,也是需要先放入到阻塞队列中,主线程将所有线程放入阻塞队列后,主线程运行完毕;
	 * @param args
	 * @throws Exception
	 * @Time: 2017年7月31日 下午5:45:33
	 * @author: TOM
	 */
	public static void main(String[] args) throws Exception {

		// 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3));
		// 设置线程池的拒绝策略为"CallerRunsPolicy"
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 新建10个任务，并将它们添加到线程池中。
		for (int i = 0; i < 10; i++) {
			Runnable myrun = new MyRunnableCallerRuns("task-" + i);
			pool.execute(myrun);
		}
		System.out.println(pool.getLargestPoolSize());
		// 关闭线程池
		pool.shutdown();
	}
}

class MyRunnableCallerRuns implements Runnable {
	private String name;

	public MyRunnableCallerRuns(String name) {
		this.name = name;
	}

	public void run() {
		try {
			System.out.println(this.name + " is running.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}