package cn.itcast.zjw;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
	public static void main(String[] args) {
		Person person1 = new Person("张三1","男");
		Person person2 = new Person("张三2","男");
		Person person3 = new Person("张三3","男");
		Person person4 = new Person("张三4","男");
		List<Person> persons = new ArrayList<Person>();
		persons.add(person4);
		persons.add(person3);
		persons.add(person2);
		persons.add(person1);
		System.out.println(persons);
		int age = 10;
		for(Person person:persons){
			person.setAge(age);
			age = age +3;
		}
		System.out.println(persons);
	}
}
