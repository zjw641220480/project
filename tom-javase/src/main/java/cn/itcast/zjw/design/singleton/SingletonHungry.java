package cn.itcast.zjw.design.singleton;

/**
 * @Description <p>
 *              饿汉式加载
 *              </p>
 * @author TOM
 * @date 2016年5月20日 下午4:03:00
 * @version V1.3.1
 */
public class SingletonHungry {
	Singleton singleton = new Singleton();

	/** 
	 * @MethodName:getSingleton
	 * @Desition:最基础的饿汉式产生单例
	 * @author TOM
	 * @return  
	 */
	public Singleton getSingleton() {
		return singleton;
	}
}
