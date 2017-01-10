package cn.itcast.zjw.thread.callable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.itcast.zjw.thread.callable.consum.CallableConsum;
import cn.itcast.zjw.thread.callable.consum.one.CallableConsumName;
import cn.itcast.zjw.thread.callable.consum.two.CallableConsumBody;
import cn.itcast.zjw.thread.callable.product.CallableProduct;
import cn.itcast.zjw.thread.callable.product.one.CallableProductName;
import cn.itcast.zjw.thread.callable.product.one.CallableProductSex;
import cn.itcast.zjw.thread.callable.product.two.CallableProductBody;
import cn.itcast.zjw.thread.callable.product.two.CallableProductSoul;
/*
 * 困难的地方在多线程加锁
 * */
/** 
 * @ClassName:CallableMain
 * @Description:
 * @author TOM
 * @date 2016年5月24日 下午2:48:00
 * @version V1.0.0
 */ 
public class CallableMain {
	public static void main(String[] args) throws InterruptedException {
		// 两份公有资源
		CallableResourceOne resourceOne = new CallableResourceOne();
		CallableResourceTwo resourceTwo = new CallableResourceTwo();
		// 四个生产者
		CallableProductName produceName = new CallableProductName(resourceOne);
		CallableProductSex produceSex = new CallableProductSex(resourceOne);
		CallableProductBody productBody = new CallableProductBody(resourceTwo);
		CallableProductSoul productSoul = new CallableProductSoul(resourceTwo);
		
		List<CallableProduct>  callableProduces = new ArrayList<CallableProduct>();
		callableProduces.add(produceName);
		callableProduces.add(produceSex);
		callableProduces.add(productBody);
		callableProduces.add(productSoul);
		//上边的也都只是准备工作罢了
		ExecutorService executor = Executors.newFixedThreadPool(4);
		//下面这一句话用来判断各个线程是否执行完毕
		List<Future<Object>> future = executor.invokeAll(callableProduces);
		//返回值的遍历
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
		System.out.println(resourceOne.getName()+"\t"+resourceOne.getSex()+"\t"+resourceTwo.getBody()+"\t"+resourceTwo.getSoul());
		// 2个消费者
		CallableConsumBody consumBody = new CallableConsumBody(resourceTwo);
		CallableConsumName consumName = new CallableConsumName(resourceOne);
		List<CallableConsum> callableConsums = new ArrayList<CallableConsum>();
		callableConsums.add(consumBody);
		callableConsums.add(consumName);
		ExecutorService executorConsums = Executors.newFixedThreadPool(4);
		executorConsums.invokeAll(callableConsums);
	}
}
