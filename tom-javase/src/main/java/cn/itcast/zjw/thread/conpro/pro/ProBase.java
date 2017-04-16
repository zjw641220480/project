package cn.itcast.zjw.thread.conpro.pro;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

import cn.itcast.zjw.thread.conpro.OriData;
import cn.itcast.zjw.thread.conpro.Resource;

/**
 *
 * <p>Title:Pro.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午6:42:45
 */
public abstract class ProBase implements Callable<String>{
	private Resource resource;
	private OriData data;
	private Lock lock;
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public OriData getData() {
		return data;
	}

	public void setData(OriData data) {
		this.data = data;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
}
