package cn.itcast.zjw.genericity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * ?通配符,也可以理解为占位符,
 * 泛型的限定,<? extends Object>可以接受Object的本类型以及其子类型,上限限定;
 * <? super Object>可以接收Object的本类型以及其父类型,下限限定
 * <?>任何类型都可以进行接受
 * ClassName: GenericityAdvance 
 * @Description: TODO
 * @author Tom
 * @date 2016年4月13日
 */
public class GenericityAdvance {
	public static void main(String[] args) {
		ArrayList<String> arrayList1 = new ArrayList<String>();
		arrayList1.add("a");
		arrayList1.add("b");
		arrayList1.add("c");
		arrayList1.add("d");
		printList(arrayList1);
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		arrayList2.add(1);
		arrayList2.add(2);
		arrayList2.add(3);
		arrayList2.add(4);
		printList(arrayList2);
	}
	@Test
	public void testPersons(){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("zhangsan"));
		persons.add(new Person("lisi"));
		persons.add(new Person("wanger"));
		GenericityAdvance.printList(persons);
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("xuesheng1"));
		students.add(new Student("xuesheng2"));
		students.add(new Student("xuesheng3"));
		GenericityAdvance.printList(students);
		
	}
	//使用?来作为占位符使用,不需要在返回值前面进行定义,
	//使用T的时候可以使用T来接收,但是需要在返回值前面进行定义,而且问号不能接收泛型中的值
	//使用了泛型之后,因为没有指定特定类型,所以就不能使用类型特有的方法;T就相当于Object
	private static <T>  void printList(List<T> list){
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext()){
			T t = iterator.next();
			System.out.println(t);
		}
	}

	/**
	 * 使用?来唯一性的指定传入的是一个体系,泛型限定
	 * 默认是直接可以传递限定的子类型的
	 * @Description: TODO
	 * @param list   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月13日
	 */
	@SuppressWarnings("unused")
	private void printListPerson(List<? extends Person> list){
		Iterator<? extends Person> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
class Person{
	private String name;
	private int age;
	public Person(){}
	public Person(String name) {
		super();
		this.name = name;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
class Student extends Person{
	public Student(String name){
		super(name);
	}
}