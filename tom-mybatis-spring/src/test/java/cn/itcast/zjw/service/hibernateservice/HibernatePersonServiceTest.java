package cn.itcast.zjw.service.hibernateservice;

import org.junit.Test;

import cn.itcast.zjw.domain.hibernate.Person;

public class HibernatePersonServiceTest {
	HibernatePersonService hibernatePersonService = new HibernatePersonService();
	@Test
	public void testTestSavePerson() {
		Person person = new Person();
		person.setPname("张三");
		person.setPsex("女");
		int count = hibernatePersonService.testSavePerson(person);
		System.out.println("插入数据的条数为\t"+count);
	}
	/** 
	 * @MethodName:testGetPerson
	 * @Desription:
	 * @date:2016年5月26日
	 * @author TOM  
	 */
	@Test
	public void testGetPerson(){
		Person person = hibernatePersonService.testGetPerson(5l);
		System.out.println(person);
	}
}
