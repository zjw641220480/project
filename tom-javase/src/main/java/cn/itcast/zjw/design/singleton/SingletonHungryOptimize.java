package cn.itcast.zjw.design.singleton;

/**
 * @Description <p>
 *              懒汉式加载的优化
 *              </p>
 * @author TOM
 * @date 2016年5月20日 下午4:13:24
 * @version V1.3.1
 */
public class SingletonHungryOptimize {
	private SingletonHungryOptimize() {
	}

	
	/** 
	 * @Description:完美方式获取单例;
	 * @author TOM
	 * @date 2016年5月23日 上午10:03:23
	 * @version V1.3.1
	 */ 
	private static class InitializeSingleton {
		//这里的new Singleton();也可以直接是写成一个方法来生成单例;
		private static Singleton singleton = new Singleton();
		public static Singleton instance(){
			return singleton;
		}
	}

	public static Singleton getInstance() {
		return InitializeSingleton.instance();
	}
}
