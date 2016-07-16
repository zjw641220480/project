package cn.itcast.zjw.design.singleton;

/**
 * 
 * @ClassName:SingleLazy
 * @Description:最基础的懒汉式单利模式
 * @author TOM
 * @Time: 2016年7月15日下午11:08:01
 */
public class SingleLazy {
	//需要保证的单利对象
	private Singleton singleton = null;
	/** 
	 * @MethodName:getSingleton
	 * @Desition:最基础的懒汉式获取单例模式
	 * @author TOM
	 * @return  
	 */
	public Singleton getSingleton() {
		if (singleton == null) {
			//使用资源进行加锁
			synchronized (singleton) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		} else {
			return singleton;
		}
		return singleton;
	}
}
