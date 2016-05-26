package cn.itcast.zjw.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.zjw.domain.hibernate.Pserson;
import cn.itcast.zjw.util.HibernateUtil;

/**
 * ClassName: GeneratorTest 
 * @Description: 主键生成机制的测试;
 * @author Tom
 * @date 2016-2-20
 */
public class GeneratorTest extends HibernateUtil{
	public void addNative(){
		//和identity很类似都是需要主键自增长的支持;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Pserson person = new Pserson();
		person.setPname("小小");
		person.setPsex("女");
		
		session.save(person);
		transaction.commit();
		session.close();
	}
	/**
	 * @Description: 对increment方式生成主键的测试
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	@Test
	public void testIncrement(){
		/*
		 *  Hibernate: select max(pid) from Pserson
			Hibernate: insert into Pserson (pname, psex, pid) values (?, ?, ?)
			说明:
			1,主键的类型必须是数字--int
			2,主键的生成是由hibernate内部完成的,程序员不需要干预;
			3,这种生成机制效率比较低;
		 * */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Pserson person = new Pserson();
		person.setPname("上海");
		person.setPsex("女");
		
		session.save(person);
		transaction.commit();
		session.close();
	}
	/**
	 * @Description: 对increment方式生成主键的测试
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	@Test
	public void testIdentity(){
		/*
		 * Hibernate: insert into Pserson (pname, psex) values (?, ?)
		 * 说明:
		 * 	1:新的主键的产生,是由数据库完成的,并不是由hibernate或者程序员完成的
		 * 	2:使用这种方式的时候该表必须支持自动增长模式;
		 * 	3:效率比较高;
		 * */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Pserson person = new Pserson();
		person.setPname("上海");
		person.setPsex("女");
		
		session.save(person);
		transaction.commit();
		session.close();
	}
	public void testUUID(){
		/*
		 * 这个并没有做实验;
		 * 1:UUID是由hibernate内部生成的;
		 * 2:主键的类型必须是字符串;
		 * */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Pserson person = new Pserson();
		person.setPname("上海");
		person.setPsex("女");
		
		session.save(person);
		transaction.commit();
		session.close();
	}
}
