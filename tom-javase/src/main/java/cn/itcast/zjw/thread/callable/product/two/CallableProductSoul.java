package cn.itcast.zjw.thread.callable.product.two;

import cn.itcast.zjw.thread.callable.CallableResourceTwo;

public class CallableProductSoul extends CallableProductTwo{

	public CallableProductSoul(CallableResourceTwo resourceTwo) {
		super(resourceTwo);
	}

	public Object call() throws Exception {
		this.getResourceTwo().setSoul("生产Soul完成");
		return "soul生产完成";
	}
	
}
