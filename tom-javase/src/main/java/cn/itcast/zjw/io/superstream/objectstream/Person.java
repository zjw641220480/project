package cn.itcast.zjw.io.superstream.objectstream;

import java.io.Serializable;

/**
 * 
 * @ClassName:Person
 * @Description:供ObjectOutputStream流进行操作对象而创建的类;
 * @author Tom
 * @Time:2016年7月25日
 *
 */
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	//这个属性会因为关键字transient的存在而不会被序列化,
	private transient String hobby;
	//因为静态成员是在方法区存在,序列化只是序列化堆内存中的内容,所以这个静态成员也不会被序列化
	private static String country;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		Person.country = country;
	}
//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + "]";
//	}
}
