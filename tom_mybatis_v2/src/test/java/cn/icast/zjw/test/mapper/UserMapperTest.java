package cn.icast.zjw.test.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.mapper.UserMapper;
import cn.itcast.zjw.mybatis.pojo.User;
import cn.itcast.zjw.mybatis.pojo.UserCustomer;
import cn.itcast.zjw.mybatis.pojo.UserQueryVo;
/**
 * 此mapper测试类中主要包含高级对象的测试
 * @ClassName:UserMapperTest
 * @Description:mapper代理的开发方式;需要也是需要先使用SqlSessionFactory获取sqlSession,再获取代理对象进行操作;
 * @Time:2017年2月14日
 * @author:Tom
 */
public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	 * @Method:init
	 * @Description:初始化SqlSessionFactory
	 * @auther:TOM
	 * @date:2016年12月17日 下午2:57:57
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		File file = Resources.getResourceAsFile(resource);
		//只有这么一种流方式来进行手动加载SqlMapConfig.xml配置文件;
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream(file));
	}
	/**
	 * 
	 * @Method:testFindUserById
	 * @Description:使用Mapper代理方式的测试,mapper代理对象是通过返回值来确定是选用selectOne还是selectList方法;
	 * @auther:TOM
	 * @date:2016年12月22日 下午8:45:15
	 */
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		sqlSession.close();
		System.out.println(user);
	}
	/**
	 * 
	 * @MethodName:testFindUserList
	 * @Description:
	 * @Time:2017年2月14日下午4:14:29
	 * @author:Tom
	 */
	@Test
	public void testFindUserList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setUsername("zang");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> users = userMapper.findUserList(userQueryVo);
		sqlSession.close();
		System.out.println(users);
	}
	/**
	 * 
	 * @MethodName:testFindUserListResultMap
	 * @Description:使用resultMap进行映射的第一个案例
	 * @Time:2017年2月14日下午6:02:48
	 * @author:Tom
	 */
	@Test
	public void testFindUserListResultMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setUsername("zang");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> users = userMapper.findUserListResultMap(userQueryVo);
		sqlSession.close();
		System.out.println(users);
	}
	/**
	 * 
	 * @MethodName:testFindUserListByIds
	 * @Description:使用foreach循环取数
	 * @Time:2017年2月14日下午7:28:46
	 * @author:Tom
	 */
	@Test
	public void testFindUserListByIds(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		userQueryVo.setIds(list);
		List<UserCustomer> customers = userMapper.findUserListByIds(userQueryVo);
		System.out.println(customers);
	}
}
