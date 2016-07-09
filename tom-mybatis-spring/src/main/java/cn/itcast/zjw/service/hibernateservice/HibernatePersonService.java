package cn.itcast.zjw.service.hibernateservice;

import cn.itcast.zjw.dao.hibernate.onlyhibernate.PersonDao;
import cn.itcast.zjw.domain.hibernate.Person;

/** 
 * @ClassName:HibernatePersonService
 * @Description:Hibernate没有和Spring整合时候的Service层
 * @author TOM
 * @date 2016年5月26日 上午10:10:19
 * @version V1.0.0
 */ 
public class HibernatePersonService {
	private PersonDao personDao = new PersonDao();
	/** 
	 * @MethodName:testSavePerson
	 * @Desription:Service层测试Hibernate
	 * @date:2016年5月26日
	 * @author TOM
	 * @param person
	 * @return  
	 */
	public int testSavePerson(Person person){
		return personDao.testSavePerson(person);
	}
	/** 
	 * @MethodName:testGetPerson
	 * @Desription:Service层测试Hibernage查找某一条数据
	 * @date:2016年5月26日
	 * @author TOM
	 * @param id
	 * @return  
	 */
	public Person testGetPerson(long id){
		return personDao.testGetPerson(id);
	}
}
