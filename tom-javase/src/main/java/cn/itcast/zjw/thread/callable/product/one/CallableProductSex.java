package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;

public class CallableProductSex extends CallableProdutOne{

	public CallableProductSex(CallableResourceOne resourceOne) {
		super(resourceOne);
	}

	public String call() throws Exception {
		this.getResourceOne().setSex("男");
		return "性别生产完成";
	}
	
}
