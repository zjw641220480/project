package cn.itcast.zjw.aop.proxy.jdkproxy;


import org.junit.Test;

import cn.itcast.zjw.base.domain.Person;

/** 
 * @ClassName:TargetObject
 * @Description:最原始的目标对象,后面需要进行增强
 * @author TOM
 * @date 2016年5月27日 下午1:28:43
 * @version V1.0.0
 */ 
public class JdkTargetObject implements ObjectInterface{
	/**
	 * 目标类实现了对应的接口;
	 */
	@Test
	public Person showPersonName(String name){
		System.out.println("最原始的Jdk类型目标对象中的方法运行了");
		System.out.println("传递进来的输入参数为:\t"+name);
		Person person = new Person();
		person.setPid(1l);
		person.setName(name);
		return person;
	}
}
