package cn.itcast.zjw.thread.callable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
	public static void main(String[] args) throws InterruptedException {
		CallableResource resource = new CallableResource();
		CallableProduceName produceName = new CallableProduceName(resource);
		CallableProduceSex produceSex = new CallableProduceSex(resource);
		List<CallableProduce>  callableProduces = new ArrayList<CallableProduce>();
		callableProduces.add(produceName);
		callableProduces.add(produceSex);
		//上边的也都只是准备工作罢了
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//下面这一句话用来判断各个线程是否执行完毕
		List<Future<Object>> future = executor.invokeAll(callableProduces);
		
		Iterator<Future<Object>> iterator = future.iterator();
		while(iterator.hasNext()){
			Future<Object> innerfuture =  iterator.next();
			try {
				System.out.println(innerfuture.isDone());
				System.out.println(innerfuture.get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(future.size());
		executor.shutdown();
		System.out.println(resource.getName()+"\t"+resource.getSex());
	}
}
