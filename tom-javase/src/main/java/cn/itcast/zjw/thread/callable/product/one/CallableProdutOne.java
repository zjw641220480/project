package cn.itcast.zjw.thread.callable.product.one;

import cn.itcast.zjw.thread.callable.CallableResourceOne;
import cn.itcast.zjw.thread.callable.product.CallableProduct;
/**
 * 
 * @ClassName:CallableProdutOne
 * @Description:用来生产性别和年龄的抽象类,里面存放了公共的资源resourceOne
 * @author TOM
 * @Time: 2016年7月14日上午11:18:29
 */
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
