package cn.itcast.zjw.design.singleton;

/**
 * 
 * @ClassName:SingletonHungry
 * @Description:标准的饿汉式单例模式
 * @author TOM
 * @Time: 2016年7月15日下午11:11:47
 */
public class SingletonHungry {
	Singleton singleton = new Singleton();
	/** 
	 * @MethodName:getSingleton
	 * @Desition:最基础的饿汉式产生单例,直接返回此单例模式
	 * @author TOM
	 * @return  
	 */
	public Singleton getSingleton() {
		return singleton;
	}
}
