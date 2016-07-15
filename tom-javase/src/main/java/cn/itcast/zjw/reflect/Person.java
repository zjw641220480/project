package cn.itcast.zjw.reflect;

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
	public static void testStaticMethod(){
		System.out.println("使用反射来调用静态方法");
	}
}
