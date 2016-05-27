package cn.itcast.zjw.thread.callable.consum.two;

import cn.itcast.zjw.thread.callable.CallableResourceTwo;
import cn.itcast.zjw.thread.callable.consum.CallableConsum;

public abstract class CallableConsumTwo implements CallableConsum{
	private CallableResourceTwo resourceTwo;
	
	public CallableResourceTwo getResourceTwo() {
		return resourceTwo;
	}

	public void setResourceTwo(CallableResourceTwo resourceTwo) {
		this.resourceTwo = resourceTwo;
	}

	public CallableConsumTwo(CallableResourceTwo resourceTwo){
		this.resourceTwo = resourceTwo;
	}
}
