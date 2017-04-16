package cn.itcast.zjw.thread.conpro.com;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

import cn.itcast.zjw.thread.conpro.OriData;
import cn.itcast.zjw.thread.conpro.Resource;

/**
 *
 * <p>Title:ComBase.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午7:21:29
 */
public abstract class ComBase implements Callable<String>{
	private Resource resource;
	private Lock lock;
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}


	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}
	
}
