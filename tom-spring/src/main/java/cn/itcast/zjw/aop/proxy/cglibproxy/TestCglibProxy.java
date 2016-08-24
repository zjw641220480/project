package cn.itcast.zjw.aop.proxy.cglibproxy;

import org.junit.Test;

import cn.itcast.zjw.base.domain.Person;
/**
 * 
 * @ClassName:TestCglibProxy
 * @Description:目标类是代理类的父类;
 * @Time:2016年8月23日
 * @author:Tom
 */
public class TestCglibProxy {
	@Test
	public void testCglibProxy(){
		Person person = new Person();
		person.setName("张三");
		//创建目标对象
		PersonDao  personDao = new PersonDaoImpl();
		//创建切面类
		Transaction transaction = new Transaction();
		//创建拦截器对象
		MyInterceptor interceptor = new MyInterceptor(personDao, transaction);
		personDao = (PersonDao) interceptor.createProxy();
		personDao.savePerson(person);
	}
	@Test
	public void testSpcingCglibProxy(){
		Person person = new Person();
		person.setName("张三");
		//创建目标对象
		PersonDao personDao = new PersonDaoImpl();
		//创建切面类
		Transaction transaction = new Transaction();
		//创建拦截器对象
		SpringMyInterceptor interceptor = new SpringMyInterceptor(personDao, transaction);
		personDao = (PersonDao) interceptor.createProxy();
		personDao.savePerson(person);
	}
}
