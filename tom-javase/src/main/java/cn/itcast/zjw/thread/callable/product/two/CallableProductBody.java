package cn.itcast.zjw.thread.callable.product.two;

import cn.itcast.zjw.thread.callable.CallableResourceTwo;

public class CallableProductBody extends CallableProductTwo{
	
	public CallableProductBody(CallableResourceTwo resourceTwo) {
		super(resourceTwo);
	}

	public Object call() throws Exception {
		this.getResourceTwo().setBody("生产Body完成");
		return "body成产完成";
	}
	
}
