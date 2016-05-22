package cn.itcast.zjw.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.domain.UserCustomer;
import cn.itcast.zjw.mybatis.domain.UserQueryVo;
import cn.itcast.zjw.mybatis.mapperdevelop.UserMapper;

/**
 * ClassName: UserMapperTest 
 * @Description: mapper代理方式的开发的测试,基础的mapper代理开发,最后添加了缓存的测试
 * @author Tom
 * @date 2016-1-5
 */
public class UserMapperTest {
	private static SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis全局配置文件地址;
		String resource = "SqlMapConfig.xml";
		// 得到全局配置文件流;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂,传入mybatis全局配置文件信息(流的形式);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// 创建一个UserMapper代理对象;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserById(2);
		System.out.println(user);
	}

	@Test
	public void testFindUserByIdResultMap() throws Exception {
		// 创建一个UserMapper代理对象;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserByIdResultMap(2);
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		List<User> list = userMapper.findUserByName("zhangzan");
		System.out.println(list);
	}

	@Test
	public void testDeleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		userMapper.deleteUser(4);
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建包装对象,设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		// 这里后来使用了动态sql,如果不设置某个值,条件不会出现在sql中
		// userCustomer.setSex("1");
		// userCustomer.setUsername("zhangzan");
		// 穿入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(7);
		ids.add(9);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}

	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 创建包装对象,设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("zhangzan");
		userQueryVo.setUserCustomer(userCustomer);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count + "\t****************");
		// mapper代理也还需要手动关闭sqlSession?????
		sqlSession.close();
	}

	// 一级缓存测试
	@Test
	public void testCache1() throws Exception {
		// 创建代理对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 第一次发起请求,查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1 + "\t =========================");
		// 如果SqlSession去执行commit操作(执行增,删,改的操作),会清空sqlSession中的一级缓存,
		// 这样做的目的是为了让缓存中的存储的数据永远是最新的信息,避免脏读,

		// 更新user1这个对象;
		user1.setUsername("一级缓存");
		userMapper.updateUser(user1);
		// 执行commit操作来提交更改,并且清楚缓存
		sqlSession.commit();
		// 第二次发起请求,也是查询id为1的用户信息
		User user2 = userMapper.findUserById(1);
		System.out.println(user2 + "\t =========================");
		sqlSession.close();
	}
	//二级缓存的测试
	@Test
	public void testCatch2()throws Exception {
		//最后把当前statement设置为禁用二级缓存,
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		//第一次发起请求,查询id为1的用户,
		User user1 = userMapper1.findUserById(2);
		System.out.println(user1);
		//这里关闭,将sqlSession中的数据写到二级缓存区域,
		sqlSession1.close();
		//使用SqlSession3执行commit操作,
		User user3 = userMapper3.findUserById(2);
		user3.setUsername("二级缓存");
		userMapper3.updateUser(user3);
		//执行提交,清空UserMapper下边的二级缓存,
		sqlSession3.commit();
		sqlSession3.close();
		User user2 = userMapper2.findUserById(2);
		System.out.println(user2);
		sqlSession2.close();
		System.out.println("UserMapperTest.testCatch2()");
	}
}
