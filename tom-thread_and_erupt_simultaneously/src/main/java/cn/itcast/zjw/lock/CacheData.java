package cn.itcast.zjw.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 
 * @ClassName:CacheData
 * @Description:缓存的原理,和小的demo
 * @Time:2016年9月6日
 * @author:Tom
 */
public class CacheData {
	private Map<String,Object> map = new HashMap<String, Object>();
	public static void main(String[] args) {
		
	}
	private  ReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 * 
	 * @MethodName:getData
	 * @Description:读写锁代码展示
	 * @param key
	 * @return
	 * @Time:2016年9月6日下午5:08:05
	 * @author:Tom
	 */
	public Object getData(String key){
		lock.readLock().lock();
		Object obj = null;
		try{
			obj = map.get(key);
			if(obj == null){
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					obj = "value";//实际是去数据库查找对应数据
				} finally {
					lock.writeLock().lock();
				}
				lock.readLock().lock();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.readLock().unlock();
		}
		return obj;
	}
}
