package cn.itcast.zjw.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cn.itcast.zjw.thread.callable.consum.CallableConsum;
import cn.itcast.zjw.thread.callable.consum.one.CallableConsumName;
import cn.itcast.zjw.thread.callable.product.CallableProduct;
import cn.itcast.zjw.thread.callable.product.one.CallableProductName;
import cn.itcast.zjw.thread.callable.product.one.CallableProductSex;

public class CallableMainSimple {
	public static void main(String[] args) throws InterruptedException {

		// 一份公有资源
		CallableResourceOne resourceOne = new CallableResourceOne();
		// 两个生产者
		CallableProductName produceName = new CallableProductName(resourceOne);
		CallableProductSex produceSex = new CallableProductSex(resourceOne);
		
		List<CallableProduct>  callableProduces = new ArrayList<CallableProduct>();
		callableProduces.add(produceName);
		callableProduces.add(produceSex);
		//上边的也都只是准备工作罢了
		// 生产者线程池
		ExecutorService executor = Executors.newFixedThreadPool(4);
		//下面这一句话用来判断各个线程是否执行完毕
		List<Future<Object>> future = executor.invokeAll(callableProduces);
		System.out.println(future.size());
		executor.shutdown();
		System.out.println(resourceOne.getName()+"\t"+resourceOne.getSex());
		// 1个消费者
		CallableConsumName consumName = new CallableConsumName(resourceOne);
		List<CallableConsum> callableConsums = new ArrayList<CallableConsum>();
		callableConsums.add(consumName);
		// 消费者线程池
		ExecutorService executorConsums = Executors.newFixedThreadPool(4);
		executorConsums.invokeAll(callableConsums);
	}
}
