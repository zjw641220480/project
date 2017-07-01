package cn.itcast.zjw.design.singleton;

/**
 * 
 * @ClassName:SingletonHungryOptimize
 * @Description:最完美的单例模式的获取
 * @author TOM
 * @Time: 2016年7月16日下午1:41:10
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
	/*
	 * 这个类需要有三个成员: 
	 * 1:一个类变量(被static修饰了的成员变量)了的单例对象;
	 * 2:一个给类变量赋值的静态方法;
	 * 备注(第三个要求是并不需要的)
	 * 3:一个公共的方法提供给外部类,让外部类可以获取到此对象,外部类不需要生命该单例对象变量
	 */
	private static class InitializeSingleton {
		/*
		 * 这里的new Singleton();也可以直接是写成一个方法来生成需要被单例的实例化对象;
		 */
		// private static Singleton singleton = new Singleton();
		private static Singleton singleton = createSingleton();

		private static Singleton createSingleton() {
			return new Singleton();
		}

		// 对外提供一个公共的方法来让外部类获取到这个实例化了的单例对象;这个实际是不需要的
		@Deprecated
		public static Singleton instance() {
			return singleton;
		}
	}

	public static Singleton getInstance() {
		return InitializeSingleton.singleton;
	}
}
