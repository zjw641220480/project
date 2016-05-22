package cn.itcast.zjw.thread.callable;

import java.util.concurrent.Callable;

public abstract class CallableProduce implements Callable<Object>{
	public CallableResource resource;
	public CallableProduce(CallableResource resource){
		this.resource = resource;
	}
}
