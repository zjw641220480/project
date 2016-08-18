package cn.itcast.zjw.aop.proxy.staticproxy;

import org.junit.Test;

import cn.itcast.zjw.base.domain.Person;
/**
 * 静态代理的缺陷:
 * 	1:在该系统中有多少的dao,同样的就需要有多少的proxy对象;
 * 	2:如果目标接口有方法的变动,理所应当的目标类需要变动,但同样的,代理类也需要再进行变动,
 * 		总结起来就是,代理类中所代理的方法被写死了;
 * @ClassName:TestStaticProxy
 * @Description:静态代理模式测试
 * @Time:2016年8月16日
 * @author:Tom
 */
public class TestStaticProxy {
	@Test
	public void testStaticProxy(){
		Person person = new Person();
		//1:创建目标对象
		PersonDao personDao = new PersonDaoImpl();
		//2:创建切面
		Transaction transaction = new Transaction();
		//3:创建代理对象
		PersonDaoImplProxy personDaoImplProxy = new PersonDaoImplProxy(personDao, transaction);
		//4:调用代理对象方法
		personDaoImplProxy.savePerson(person);
	}
}
