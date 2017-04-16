package cn.itcast.zjw.thread.conpro.com;

import cn.itcast.zjw.thread.conpro.Resource;

/**
 *
 * <p>Title:ComAll.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午7:22:33
 */
public class ComAll extends ComBase{
	public ComAll(Resource resource) {
		setResource(resource);
	}
	public String call() throws Exception {
		System.out.println("消费\t"+getResource().getName());
		System.out.println("消费\t"+getResource().getAge());
		return "";
	}

}
