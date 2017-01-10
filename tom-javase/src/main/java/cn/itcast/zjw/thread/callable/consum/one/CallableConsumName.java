package cn.itcast.zjw.thread.callable.consum.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;

public class CallableConsumName extends CallableConsumOne{

	public CallableConsumName(CallableResourceOne resourceOne) {
		super(resourceOne);
	}

	public Object call() throws Exception {
		System.out.println("消费资源1的姓名为:\t"+this.getResourceOne().getName());
		return null;
	}

}
