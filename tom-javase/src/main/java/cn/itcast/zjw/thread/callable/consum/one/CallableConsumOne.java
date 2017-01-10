package cn.itcast.zjw.thread.callable.consum.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;
import cn.itcast.zjw.thread.callable.consum.CallableConsum;

public abstract class CallableConsumOne implements CallableConsum{
	private CallableResourceOne resourceOne;
	
	
	public CallableResourceOne getResourceOne() {
		return resourceOne;
	}


	public void setResourceOne(CallableResourceOne resourceOne) {
		this.resourceOne = resourceOne;
	}


	public CallableConsumOne( CallableResourceOne resourceOne){
		this.resourceOne=resourceOne;
	}
	
}
