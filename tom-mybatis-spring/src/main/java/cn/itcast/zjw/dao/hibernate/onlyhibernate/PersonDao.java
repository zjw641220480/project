package cn.itcast.zjw.dao.hibernate.onlyhibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.zjw.domain.hibernate.Person;
import cn.itcast.zjw.util.HibernateUtil;

/** 
 * @ClassName:PersonDao
 * @Description:仅仅只有Hibernate时候
 * @author TOM
 * @date 2016年5月26日 上午10:06:23
 * @version V1.0.0
 */ 
public class PersonDao {
	/** 
	 * @MethodName:testSavePerson
	 * @Desription:测试插入数据
	 * @date:2016年5月26日
	 * @author TOM
	 * @param person
	 * @return  
	 */
	public int testSavePerson(Person person){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		session.close();
		return 1;
	}
	/** 
	 * @MethodName:testGetPerson
	 * @Desription:测试查找某一条数据
	 * @date:2016年5月26日
	 * @author TOM
	 * @param id
	 * @return  
	 */
	public Person testGetPerson(long id){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Person person = session.get(Person.class, id);
		transaction.commit();
		session.close();
		return person;
	}
}
