package cn.itcast.zjw.domain;

import java.io.Serializable;

/**
 * 
 * @ClassName:Person
 * @Description:公共的Person类
 * @author TOM
 * @Time: 2016年7月16日下午1:53:24
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int age;

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
	public Person(){}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * 被复写了的hashCode()和equals()方法,在hashSet中判断元素是否重复的时候会被用到
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	/*
	 * 另一种判断List集合中元素是否重复的依据
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((name == null) ? 0 : name.hashCode()); return
	 * result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; Person other = (Person) obj; if (name == null) { if
	 * (other.name != null) return false; } else if (!name.equals(other.name))
	 * return false; return true; }
	 */
	public Person createPerson(){
		return new Person();
	}
}
