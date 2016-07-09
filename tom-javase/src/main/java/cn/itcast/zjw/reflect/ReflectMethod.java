package cn.itcast.zjw.reflect;

import java.lang.reflect.Method;

public class ReflectMethod {
	public static void main(String[] args) throws Exception {
		ReflectMethod reflectPerson = new ReflectMethod();
		reflectPerson.operatorMethod();
		reflectPerson.operatorStaticMethod();
	}
	/**
	 * @Method: operatorMethod
	 * @Description:使用反射操作普通方法
	 * @throws Exception 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	public void operatorMethod() throws Exception{
		Class<?> personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		// 得到所有方法
		personClass.getDeclaredConstructors();
		// 得到指定方法,传递两个参数,第一个参数,方法的名称,第二个参数,方法的输入参数
		Method methodName = personClass.getDeclaredMethod("setName", String.class);
		// 得到Person实例
		Person person = (Person) personClass.newInstance();
		// 当操作的是一个私有的方法的时候,需要设置值未true
		methodName.setAccessible(true);
		// 让指定的方法运行,传递两个参数,第一个参数Person实例,第二个参数,就是方法参数的值,执行了invoke方法之后,相当于执行了指定的方法,
		methodName.invoke(person, "lisi");
		System.out.println(person.getName());
	}
	/**
	 * @Method: operatorStaticMethod
	 * @Description:使用反射来操作静态的无参普通方法
	 * @throws Exception 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	public void operatorStaticMethod() throws Exception{
		Class<?> personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		Method staticMethod = personClass.getDeclaredMethod("testStaticMethod", null);
		staticMethod.invoke(null, null);
	}
}
