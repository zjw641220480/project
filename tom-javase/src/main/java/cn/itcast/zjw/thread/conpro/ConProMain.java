package cn.itcast.zjw.thread.conpro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.itcast.zjw.thread.conpro.OriData;
import cn.itcast.zjw.thread.conpro.Resource;
import cn.itcast.zjw.thread.conpro.com.ComAll;
import cn.itcast.zjw.thread.conpro.pro.ProAge;
import cn.itcast.zjw.thread.conpro.pro.ProBase;
import cn.itcast.zjw.thread.conpro.pro.ProName;

/**
 *
 * <p>Title:ConProMain.java</p>
 * <p>Description:暂时没有其它客户端来保存队列,只能是生产一个消费一个</p>
 * @author TOM
 * @date 2017年4月11日下午6:52:38
 */
public class ConProMain {
	public static void main(String[] args) throws InterruptedException {
		int count = 10;
		Lock lockPro = new ReentrantLock(); 
		//线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		Resource resource = new Resource();
		ArrayBlockingQueue<Resource> arrayBlockingQueue = new ArrayBlockingQueue<Resource>(10);
		while(true){
			Thread.sleep(1000);
			count++;
			//一份资源
			OriData data = new OriData();
			data.setAge(count);
			data.setName("zhangsan");
			ProAge proAge = new ProAge(resource, data,lockPro);
			ProName proName = new ProName(resource, data,lockPro);
			List<Callable<String>> tasks = new ArrayList<Callable<String>>();
			tasks.add(proAge);
			tasks.add(proName);
			executorService.invokeAll(tasks);
			arrayBlockingQueue.put(resource);
			System.out.println(arrayBlockingQueue.size());
			
			//消费者
			ComAll all = new ComAll(resource);
			executorService.submit(all);
			arrayBlockingQueue.take();
		}
	}
}
