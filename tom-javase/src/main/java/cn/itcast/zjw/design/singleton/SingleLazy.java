package cn.itcast.zjw.design.singleton;

/**
 * 解决并发环境下,懒汉式单例可能出现多个Singleton实例的解决方法
 *  1:在getSingleton(获取单例对象方法)上添加锁(synchronized)
 *  2:使用双重检查加锁的机制,在此种机制下会使用关键字volatile,它的意思是:被volatile修饰的变量的值,
 *  将不会被本地线程缓存,所有对该变量的读写都是直接共享内存,从而保证多个线程能够正确的处理该变量;不过此关键字导致效率不是很高,可以不加
 *  3:静态的内部类的方式:SingletonHungryOptimize在此类中使用的是此方式
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
	 * @Desition:最基础的懒汉式获取单例模式,双重判断,然后在双重判断之间加锁;
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
