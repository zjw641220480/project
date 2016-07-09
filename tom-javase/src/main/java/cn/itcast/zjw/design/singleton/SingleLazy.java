package cn.itcast.zjw.design.singleton;

/**
 * @Description <p>
 *              饿汉式
 *              </p>
 * @author TOM
 * @date 2016年5月20日 下午4:06:25
 * @version V1.3.1
 */
public class SingleLazy {
	private Singleton singleton = null;
	/** 
	 * @MethodName:getSingleton
	 * @Desition:最基础的懒汉式获取单例模式
	 * @author TOM
	 * @return  
	 */
	public Singleton getSingleton() {
		if (singleton == null) {
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
