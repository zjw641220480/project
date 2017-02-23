package cn.itcast.zjw.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class ReflectField {

	/**
	 * @Method: operatorField
	 * @Description:直接操作属性,这个一般不常用,毕竟属性一般私有,
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException 
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Test
	public void operatorField() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		Class<?> personClass = Class.forName("cn.itcast.zjw.reflect.Person");
		//得到person类的实例
		Person person = (Person) personClass.newInstance();
		//得到指定的属性
		Field fieldName = personClass.getDeclaredField("name");
		//获取操作私有方法的权限;
		fieldName.setAccessible(true);
		fieldName.set(person, "lisi");
		System.out.println(person.getName());
	}
}
