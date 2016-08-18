package cn.itcast.zjw.aop.proxy.staticproxy;

import cn.itcast.zjw.base.domain.Person;
/**
 * 
 * @ClassName:PersonDaoImplProxy
 * @Description:静态代理类对象,在静态代理对象中,有目标对象的引用和切面;
 * @Time:2016年8月16日
 * @author:Tom
 */
public class PersonDaoImplProxy implements PersonDao{
	private PersonDao personDao;
	private Transaction transaction;
	public PersonDaoImplProxy(PersonDao personDao,Transaction transaction){
		this.personDao = personDao;
		this.transaction = transaction;
	}
	public void savePerson(Person person) {
		this.transaction.openSession();
		this.personDao.savePerson(person);
		this.transaction.closeSession();
	}

}
