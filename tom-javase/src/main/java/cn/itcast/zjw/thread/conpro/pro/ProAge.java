package cn.itcast.zjw.thread.conpro.pro;

import java.util.concurrent.locks.Lock;

import cn.itcast.zjw.thread.conpro.OriData;
import cn.itcast.zjw.thread.conpro.Resource;

/**
 *
 * <p>Title:ProAge.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午6:50:55
 */
public class ProAge extends ProBase{
	public ProAge(Resource resource,OriData data,Lock lock) {
		setData(data);
		setResource(resource);
		setLock(lock);
	}
	public String call() throws Exception {
		getLock().lock();
		this.getResource().setAge(this.getData().getAge());
		getLock().unlock();
		return "1";
	}
	
}
