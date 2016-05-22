package cn.itcast.zjw.thread.callable;

public class  CallableProduceName extends CallableProduce{
	
	public CallableProduceName(CallableResource resource) {
		super(resource);
	}

	public String call() throws Exception {
		this.resource.setName("姓名:张三");
		return "xingming";
	}
	
}
