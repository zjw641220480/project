package cn.icast.zjw.test.dao;

import org.junit.Test;

import cn.itcast.zjw.mybatis.dao.UserDao;
import cn.itcast.zjw.mybatis.dao.impl.UserDaoImpl;
import cn.itcast.zjw.mybatis.pojo.User;
/**
 * 
 * @ClassName:UserDaoImplTest
 * @Description:Dao方式开发的测试,也还是需要借助SqlSession
 * @author: TOM
 * @Time:2016年12月21日
 */
public class UserDaoImplTest {

	@Test
	public void testFindUserById() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
