package cn.itcast.zjw.thread.conpro.pro;

import java.util.concurrent.locks.Lock;

import cn.itcast.zjw.thread.conpro.OriData;
import cn.itcast.zjw.thread.conpro.Resource;

/**
 *
 * <p>Title:ProName.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午6:44:38
 */
public class ProName extends ProBase{

	public ProName(Resource resource,OriData data,Lock lock) {
		setData(data);
		setResource(resource);
		setLock(lock);
	}
	public String call() throws Exception {
		getLock().lock();
		this.getResource().setName(getData().getName());
		getLock().unlock();
		return "1";
	}

}
