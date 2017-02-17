package cn.icast.zjw.test.springdao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.mybatis.dao.UserDao;
import cn.itcast.zjw.mybatis.pojo.User;

/**
 *
 * <p>Title:SpringDaoTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月17日下午4:50:35
 */
public class SpringDaoTest {
	/**
	 * 
	 * @MethodName:testSpringDaoDevelop
	 * @Description:mybatis原始dao开发方式的时候,和spring进行整合,主要是需要往dao中注入SqlSessionFactory
	 * @Time:2017年2月17日下午4:50:59
	 * @author:Tom
	 */
	@Test
	public void testSpringDaoDevelop(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoImpl");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
}
