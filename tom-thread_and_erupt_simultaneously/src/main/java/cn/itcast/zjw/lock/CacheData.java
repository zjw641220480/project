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
	{
		map.put("redis", "redis缓存中的数据");
		map.put("mysql", "从mysql数据库中查询的数据");
	}
	public static void main(String[] args) {
		CacheData cacheData = new CacheData();
		String value = (String) cacheData.getData("京东发");
		System.out.println(value);
	}
	private  ReadWriteLock lock = new ReentrantReadWriteLock();
	/**
	 * 
	 * @MethodName:getData
	 * @Description:读写锁代码展示,当读锁里面有写锁的时候,需要在开头和结尾有两层读锁;若不这样写,就会造成死锁,写的时候,获取锁被读锁拿着,写锁获取不到锁;
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
				//此处释放读锁,然后加上写锁
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					obj = "value";//实际是去数据库查找对应数据
				} finally {
					lock.writeLock().unlock();
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
