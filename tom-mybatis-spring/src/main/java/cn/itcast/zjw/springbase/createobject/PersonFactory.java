/**
 * @Project: tom-mybatis-spring @(#) PersonFactory.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.springbase.createobject;

/** 
 * @ClassName: PersonFactory
 * @Description:
 * @Time 2016年5月26日 下午10:40:48
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class PersonFactory {
	/**
	 * @Method: createPerson
	 * @Description:静态工厂创建对象
	 * @param: @return 
	 * @return: Person
	 * @date 2016年5月26日
	 * @author TOM
	 */
	public static Person createPerson(){
		return new Person();
	}
}
