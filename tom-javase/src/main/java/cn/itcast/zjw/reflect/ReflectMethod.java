package cn.itcast.zjw.reflect;

import java.lang.reflect.Method;

import org.junit.Test;
/**
 * 
 * @ClassName:ReflectMethod
 * @Description:使用反射操作类中的方法;
 * @author TOM
 * @Time: 2016年7月14日下午2:05:45
 */
public class ReflectMethod {
	/**
	 * @Method: operatorMethod
	 * @Description:使用反射操作普通方法
	 * @throws Exception 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Test
	public void operatorMethod() throws Exception{
		Class<?> personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		// 得到所有方法
		personClass.getDeclaredConstructors();
		// 得到类中的指定方法,传递两个参数,第一个参数,方法的名称,第二个参数,方法的输入参数
		Method methodName = personClass.getDeclaredMethod("testReflectMethod", String.class);
		// 得到Person实例
		Person person = (Person) personClass.newInstance();
		// 当操作的是一个私有的方法的时候,需要设置值未true
		methodName.setAccessible(true);
		// 让指定的方法运行,传递两个参数,第一个参数Person实例,第二个参数,就是方法参数的值,执行了invoke方法之后,相当于执行了指定的方法,
		methodName.invoke(person, "lisi");
	}
	/**
	 * @Method: operatorStaticMethod
	 * @Description:使用反射来操作静态的无参普通方法
	 * @throws Exception 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Test
	public void operatorStaticMethod() throws Exception{
		Class<?> personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//获取类中指定方法,需要两个类型的参数,一个为方法的名字,一个为方法的所有参数类型
		Method staticMethod = personClass.getDeclaredMethod("testStaticMethod", null);
		//使用invoke方法来运行类中指定方法的时候,也是需要两个类型的参数,第一个为实例对象,第二个为方法的参数值;
		staticMethod.invoke(null, null);
	}
}
