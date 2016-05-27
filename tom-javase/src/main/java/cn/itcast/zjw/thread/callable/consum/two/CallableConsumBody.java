package cn.itcast.zjw.thread.callable.consum.two;

import cn.itcast.zjw.thread.callable.CallableResourceTwo;

public class CallableConsumBody extends CallableConsumTwo{

	public CallableConsumBody(CallableResourceTwo resourceTwo) {
		super(resourceTwo);
	}

	public Object call() throws Exception {
		System.out.println("消费资源2的属性body:\t"+this.getResourceTwo().getBody());
		return null;
	}

}
