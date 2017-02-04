package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;
/**
 * 
 * @ClassName:CallableProductName
 * @Description:真正的实现类,复写call方法,生产姓名;
 * @author TOM
 * @Time: 2016年7月14日上午11:20:51
 */
public class  CallableProductName extends CallableProdutOne{
	
	public CallableProductName(CallableResourceOne resource) {
		super(resource);
	}

	public String call() throws Exception {
		this.getResourceOne().setName("姓名:张三");
		return "姓名生产完成";
	}
	
}
