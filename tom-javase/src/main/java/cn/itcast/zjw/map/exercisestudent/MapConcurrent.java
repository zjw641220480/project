package cn.itcast.zjw.map.exercisestudent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapConcurrent {
	private static Map<String,String> map = new HashMap<String, String>();
	static int count =0;
	@SuppressWarnings("null")
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		MapConcurrent concurrent = new MapConcurrent();
		concurrent.initMap();
		for(String key:map.keySet()){
			System.out.println(map.get(key));
		}
		System.out.println("两秒后使用线程来取数");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExecutorService executorService = Executors.newCachedThreadPool();
		Collection<Callable<String>> collection = new ArrayList<Callable<String>>();
		for(int i=0;i<20;i++){
			Callable<String> callable = new Callable<String>() {
				public String call() throws Exception {
					//lock.lock();
					Set<String> keySet = map.keySet();
					Iterator<String> iterator = keySet.iterator();
					String threadName = null;
					while(iterator.hasNext()){
						Thread.currentThread().sleep(1000);
						String key = iterator.next();
						threadName = Thread.currentThread().getName();
						System.out.println("线程"+threadName+"取得map中的值\t"+map.get(key));
						count++;
					}
					//lock.unlock();
					return null;
				}
			};
			collection.add(callable);
		}
		try {
			executorService.invokeAll(collection);
			executorService.shutdown();
			System.out.println("线程运行结束");
			System.out.println("总共循环的次数为:\t"+count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initMap(){
		map.put("s1", "v1");
		map.put("s2", "v2");
		map.put("s3", "v3");
		map.put("s4", "v4");
		map.put("s5", "v5");
		//map.put("s6", "v6");
	}
}
