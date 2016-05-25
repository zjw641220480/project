package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;

public class  CallableProductName extends CallableProdutOne{
	
	public CallableProductName(CallableResourceOne resource) {
		super(resource);
	}

	public String call() throws Exception {
		this.getResourceOne().setName("姓名:张三");
		return "姓名生产完成";
	}
	
}
