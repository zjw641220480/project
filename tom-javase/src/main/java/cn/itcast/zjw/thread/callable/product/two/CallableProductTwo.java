package cn.itcast.zjw.thread.callable.product.two;

import cn.itcast.zjw.thread.callable.CallableResourceTwo;
import cn.itcast.zjw.thread.callable.product.CallableProduct;

public abstract class CallableProductTwo implements CallableProduct{
	
	private CallableResourceTwo resourceTwo;
	
	

	public CallableResourceTwo getResourceTwo() {
		return resourceTwo;
	}



	public void setResourceTwo(CallableResourceTwo resourceTwo) {
		this.resourceTwo = resourceTwo;
	}



	public CallableProductTwo(CallableResourceTwo resourceTwo){
		this.resourceTwo = resourceTwo;
	}
}
