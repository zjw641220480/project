package cn.itcast.zjw.thread.test;

public class PersonTest {
	private static final int A;
	static{
		A = 8;
	}
	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		Person.setAge(11);
		System.out.println(Person.getAge());
		person1.setName("zhangsan");
		System.out.println(person2.getName());
	}
}
class Person{
	private static int age;
	private String name;
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		Person.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
