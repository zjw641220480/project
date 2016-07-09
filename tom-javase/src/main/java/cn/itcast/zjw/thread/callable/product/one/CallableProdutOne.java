package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;
import cn.itcast.zjw.thread.callable.product.CallableProduct;

public abstract class CallableProdutOne implements CallableProduct{
	private CallableResourceOne resourceOne;
	

	public CallableResourceOne getResourceOne() {
		return resourceOne;
	}


	public void setResourceOne(CallableResourceOne resourceOne) {
		this.resourceOne = resourceOne;
	}


	public CallableProdutOne(CallableResourceOne resourceOne){
		this.resourceOne = resourceOne;
	}
}
