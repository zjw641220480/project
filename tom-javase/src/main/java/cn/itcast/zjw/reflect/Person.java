package cn.itcast.zjw.reflect;
/**
 * 
 * @ClassName:Person
 * @Description:用于演示反射的基础类
 * @author TOM
 * @Time: 2016年7月17日上午11:05:56
 */
public class Person {
	private String name;
	private String id;
	public Person(){
		System.out.println(this.toString());
		System.out.println("Person.Person()");
		System.out.println("无参构造方法运行");
	}
	public Person(String name,String id){
		this.name = name;
		this.id = id;
		System.out.println(this.toString());
		System.out.println("Person.Person()");
		System.out.println("有两个参数的构造方法运行");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @Method:testReflectMethod
	 * @Description:使用反射操作普通方法的案例所使用的方法
	 * @author TOM
	 * @date 2016年7月18日
	 */
	public void testReflectMethod(String param){
		System.out.println(this.toString());
		System.out.println("Person.testReflectMethod()");
		System.out.println("使用反射操作普通方法的案例所使用的方法运行");
		System.out.println("传递过来的参数的值为:\t"+param);
	}
	/**
	 * 
	 * @Method:testStaticMethod
	 * @Description:使用反射操作静态方法的案例所使用的方法
	 * @author TOM
	 * @date 2016年7月18日
	 */
	public static void testStaticMethod(){
		System.out.print(Person.class);
		System.out.println("Person.testStaticMethod()");
		System.out.println("使用反射操作静态方法的案例所使用的方法运行");
	}
}
