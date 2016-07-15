package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;
/**
 * 
 * @ClassName:CallableProductSex
 * @Description:真正的实现类,复写call方法,生产性别
 * @author TOM
 * @Time: 2016年7月14日上午11:19:49
 */
public class CallableProductSex extends CallableProdutOne{

	public CallableProductSex(CallableResourceOne resourceOne) {
		super(resourceOne);
	}

	public String call() throws Exception {
		this.getResourceOne().setSex("男");
		return "性别生产完成";
	}
	
}
