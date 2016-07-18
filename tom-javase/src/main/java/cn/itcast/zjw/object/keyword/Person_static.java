package cn.itcast.zjw.object.keyword;

/**
 * @ClassName: Person_static
 * @Description:用于演示static关键字; 
 * 被static所修饰的成员的特点: 
 * 		随着类的加载而加载(那么它就是只会被加载一次了);
 * 		优先于对象存在; 
 * 		被所有对象所共享;
 *      可以直接被类名所调用;
 * 静态的使用注意事项
 * 		静态方法只能访问静态成员,
 * 		静态方法中不可以定义this,super关键字;
 * @author Tom
 * @date 2016-2-27
 */
public class Person_static {
	/*
	 * 实例变量和成员变量之间的区别; 
	 * 存放位置:类变量随着类的加载而存在于方法区中, 实例变量随着对象的建立而存在于堆内存中, 
	 * 生命周期:类变量随着类的加载而存在,随着类的消失而消失,生命周期最长; 实例变量随着对象的创建而存在,随着对象的回收而消失;
	 */
	@SuppressWarnings("unused")
	private String name;// 成员变量,实例变量
	private static String country = "CN";// 类变量

	public static void show() {
		System.out.println("国家" + country);
	}

	public static void main(String[] args) {
		System.out.println("Person_static.main()");
	}
}
