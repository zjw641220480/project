package cn.itcast.zjw.thread.callable;

public class CallableProduceSex extends CallableProduce{

	public CallableProduceSex(CallableResource resource) {
		super(resource);
	}

	public Integer call() throws Exception {
		this.resource.setSex("男");
		return 1;
	}
	
}
