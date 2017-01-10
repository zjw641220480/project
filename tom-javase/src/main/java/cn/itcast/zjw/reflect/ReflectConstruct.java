package cn.itcast.zjw.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;


/** 
 * @ClassName: ReflectConstruct
 * @Description:反射操作构造方法,Class这个类主要也就是在反射的时候使用的;构造方法的作用就是创建对象,获得的class对象都是调用newInstance()方法来创建相应对象
 * @Time 2016年6月1日 下午9:58:14
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class ReflectConstruct {
	public static void main(String[] args) throws Exception{
		ReflectConstruct reflectConstruct = new ReflectConstruct();
		//reflectConstruct.newPerson1();
		reflectConstruct.newPerson2();
	}
	/**
	 * @Method: getReflectClass
	 * @Description:获取Class类的三种方式,其中第二种方式是最常用的;
	 * @throws Exception 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Test
	@SuppressWarnings("unused")
	public void getReflectClass() throws Exception{
		//1:类名.class获取Class类;
		Class<Person> personClass = Person.class;
		//2:Class.forName()生成Class类;
		@SuppressWarnings("rawtypes")
		Class personClass2 = Class.forName("cn.itcast.zjw.reflect.Person");
		//3:对象.getClass()生成Class类;
		Person person = new Person();
		Class<? extends Person> personClass3 = person.getClass();
	}
	/**
	 * 
	 * @Method:testNoParamsConstruct
	 * @Description:无参构造方法的测试
	 * @author TOM
	 * @date 2016年7月17日
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void testNoParamsConstruct() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		this.newPerson1();
	}
	/**
	 * @Method: newPerson1
	 * @Description:使用Class类的newInstance()方法直接调用该类的无参构造方法,生成对象;
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	public void newPerson1() throws ClassNotFoundException, InstantiationException, IllegalAccessException  {
		Class personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//直接通过Class类中newInstance方法来得到Person类的实例,这个方法相当于直接调用了Person类的无参构造方法
		Person person = (Person) personClass.newInstance();
		person.setId("123"); 
		System.out.println(person.getId());
	}
	/**
	 * 
	 * @Method:testSomeParamsConstruct
	 * @Description:有参数构造方法的测试
	 * @author TOM
	 * @date 2016年7月17日
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void testSomeParamsConstruct() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		this.newPerson2();
	}
	/**
	 * @Method: newPerson2
	 * @Description:操作有参数的构造方法,也是需要使用newInstance方法,这个方法是重载的,
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	public void newPerson2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//获取所有的构造方法
		Constructor[] constructors = personClass.getConstructors();
		//获取某一个指定的构造方法
		//传递的是有参数的构造方法里面参数类型,类型使用的是class形式来进行传递;
		Constructor constructor = personClass.getConstructor(String.class,String.class);
		//得到操作私有构造方法的权限;
		constructor.setAccessible(true);
		//通过又参数的构造方法来向对象中进行传值
		Person person = (Person) constructor.newInstance("李四","100");
		System.out.println(person.getName()+"\t"+person.getId());
	}
}
