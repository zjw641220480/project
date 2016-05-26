package cn.itcast.zjw.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.zjw.domain.hibernate.Pserson;
import cn.itcast.zjw.util.HibernateUtil;


public class PersonTest extends HibernateUtil{
	
	/**
	 * @Description: 第一天对person的增的操作; 
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	public void testSavePerson(){
		//打开了一个数据库的链接;
		//这里如果说是执行cud操作的时候,首先是需要进行开启事务,
		//进行cud的操作,提交事务,关闭session
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Pserson person = new Pserson();
		person.setPname("上海");
		//person.setPsex("女");
		//save中的参数必须是在映射文件(*.hbm.xml)中配置的持久化类;
		session.save(person);
		
		transaction.commit();
		session.close();
	}
	/**
	 * @Description: 对单表person的查的操作,并且是使用hql语句来查询所有;--createQuery("from Pserson").list();
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	public void testQueryPerson(){
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Pserson> list = session.createQuery("from Pserson").list();
		for(Pserson p:list){
			System.out.println(p.getPname());
		}
		session.close();
	}
	/**
	 * @Description: 根据id来查询单表person的信息 ,session.get(Pserson.class, 1l);
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	public void testQueryPersonById(){
		Session session = sessionFactory.openSession();
		/*
		 * 按照主键的方式查询数据库中表中的记录;
		 * 第二个参数的类型必须和持久化中属性(标识符)的类型保持一直;
		 * 利用session.get方法产生一个对象,调用的是默认的构造函数;所以一个持久化类中必须有一个
		 * 默认的构造函数;
		 * */
		Pserson person = (Pserson) session.get(Pserson.class, 1l);
		System.out.println(person.getPname());
		session.close();
	}
	
	/**
	 * @Description: 对单表person的删除操作;
	 * Hibernate会检查标识符,看标识符中的值在数据库相应的表中有没有相应的记录;
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	public void testDeletePerson(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*
		 * 根据id把值查询出来,把对象删除掉;
		 * 也就是说,删除之前先查找出来要删除的对象;然后是删除这个对象;
		 * 如果说数据库中不存在此数据,删除的时候,总是会报告错误
		 * */
		Pserson person = (Pserson) session.get(Pserson.class, 4l);
		session.delete(person);
		/*
		 * 1:新创建一个person对象,
		 * 2:给person对象的标识符赋值;
		 * 3:调用session.delete方法删除;
		 * */
//		Pserson person = new Pserson();
//		person.setPid(2l);
//		session.delete(person);
		transaction.commit();
		session.close();
	}
	/**
	 * @Description: 对单表person中数据的修改操作; 
	 * 删除和修改都需要先查询出来要修改的对象,然后是对同一个对象的操作;
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016-2-20
	 */
	public void testUpdatePerson(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/*
		 * 1:根据id把持久化对象提取出来;
		 * 2:进行修改,
		 * 3:执行update操作;
		 * */
		Pserson person = (Pserson) session.get(Pserson.class, 3l);
		person.setPname("uueyy");
		//session.update(person);这一句话只是把person对象转化为持久化对象,
		//在上面的时候session.get方法已经把person转化为持久化对象;
		//hibernate是根据主键来确定是对数据库的什么操作的;
		transaction.commit();
		session.close();
	}
	
	public void testClear(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pserson person = (Pserson) session.get(Pserson.class, 3l);
		person.setPname("往往");
		session.clear();//把session中的所有对象清空;
		session.update(person);//把对象从托管状态转化为持久化状态;而且这句话必须放置在clear方法的后面
		transaction.commit();
		session.close();
	}
	
	public void testEvict(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pserson person = (Pserson) session.get(Pserson.class, 3l);
		person.setPname("aaa");
		session.evict(person);//把session中的一个对象清空,
		session.update(person);//把对象的状态转变为持久化状态;
		transaction.commit();
		session.close();
	}
	
	public void testSession(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pserson person = (Pserson) session.get(Pserson.class, 3l);
		person.setPname("张家界");
		session.update(person);
		transaction.commit();
		session.close();
		
		//上下的这两个session不是同一个,
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		person.setPname("jfajfja");//这个person对下岗对于上面一个session来说是一个临时状态对象
		//session.update(person);
		transaction.commit();
		session.close();
		//上面两段都执行了,最后数据库中更改的结果为第二个session的
	}
	@Test
	public void testMuplyOption(){
		/*
		 * 1:当执行transaction.commit()的时候hibernate内部会检查session
		 * 2:如果一个对象是临时状态的对象,则session并不会去管理
		 * 3:如果一个对象是持久化状态对象,如果有id值,并且和数据库相互对应,那么先把该对象与快照进行对比,如果一致则什么都不做,
		 * 如果不一致则发出update语句;
		 * 4:如果一个对象是持久化状态的,如果没有id值则会发出save语句;
		 * */
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pserson person = new Pserson();
		person.setPname("往往");
		person.setPsex("nv");
		session.save(person);
		
		Pserson person3 = new Pserson();
		person3.setPname("往往");
		person3.setPsex("nv");
		
		Pserson person2 = (Pserson) session.get(Pserson.class, 3l);
		person2.setPname("afdsdfa");
		//这一句话虽然并没有发出update方法,但是其也照样执行了,更改了数据库中3的值;
		transaction.commit();
		//当我进行这一句的时候session就会检查里面对象的状态,对于person3,session是不会去管理他的
		session.close();
	}
	public void testMutiplyoption2(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Pserson person = new Pserson();
		person.setPname("fja");
		person.setPsex("nv");
		session.save(person);
		transaction.commit();
		session.evict(person);
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.update(person);
		session.clear();
		transaction.commit();
		session.close();
	}
}
