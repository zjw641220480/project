package cn.itcast.zjw.design.singleton;
/**
 * 
 * @ClassName:Singleton
 * @Description:需要被创建为单例对象的类;
 * @author TOM
 * @Time: 2016年7月16日下午1:40:39
 */
public class Singleton {
	public Singleton(){
		super();
		System.out.println(this.toString());
		System.out.println("Singleton.Singleton()");
		System.out.println("Singleton单例实例被创建");
	}
}
