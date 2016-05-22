package cn.itcast.zjw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Administrator
 *
 */
public class ReflectConstruct {
	public static void main(String[] args) throws Exception{
		//获取Class类的三种方式
		ReflectConstruct reflectConstruct = new ReflectConstruct();
		reflectConstruct.newPerson1();
		reflectConstruct.newPerson2();
	}
	public void getReflectClass() throws Exception{
		Class<Person> personClass = Person.class;
		Class personClass2 = Class.forName("cn.itcast.zjw.reflect.Person");
		Person person = new Person();
		Class<? extends Person> personClass3 = person.getClass();
	}
	/**
	 * 操作无参数的构造方法
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void newPerson1() throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Class personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//直接通过Class类中newInstance方法来得到Person类的实例,这个方法相当于直接调用了Person类的无参构造方法
		Person person = (Person) personClass.newInstance();
		person.setId("123"); 
		System.out.println(person.getId());
	}
	/**
	 * 操作有参数的构造方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void newPerson2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//获取所有的构造方法
		Constructor[] constructors = personClass.getConstructors();
		//获取某一个指定的构造方法
		//传递的是有参数的构造方法里面参数类型,类型使用的是class形式来进行传递;
		Constructor constructor = personClass.getConstructor(String.class,String.class);
		//通过又参数的构造方法来向对象中进行传值
		Person person = (Person) constructor.newInstance("李四","100");
		System.out.println(person.getName()+"\t"+person.getId());
	}
	
}
