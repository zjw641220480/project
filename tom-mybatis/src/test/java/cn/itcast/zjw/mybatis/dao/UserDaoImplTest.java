package cn.itcast.zjw.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.daodevelop.UserDao;
import cn.itcast.zjw.mybatis.daodevelop.UserDaoImpl;
import cn.itcast.zjw.mybatis.domain.User;

public class UserDaoImplTest {
	private static SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		// ����sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// ����UserDao����
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		// ����UserDaoImpl�е���ط���;
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
}
