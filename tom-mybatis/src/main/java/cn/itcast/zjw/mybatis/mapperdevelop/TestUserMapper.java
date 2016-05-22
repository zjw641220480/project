package cn.itcast.zjw.mybatis.mapperdevelop;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.domain.UserCustomer;
import cn.itcast.zjw.mybatis.domain.UserQueryVo;

public class TestUserMapper {
	private SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void beforeTest(){
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建会话工厂,
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	/**
	 * @Description: 根据主键id来查询
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserByIdMapperDevelop() throws Exception{
		//创建UserMapper对象;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	/**
	 * @Description: 根据name来模糊查询
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserByNameMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserByName("测");
		System.out.println(list);
	}
	/**
	 * @Description: 根据包装对象QueryVo来综合查询(高级查询)
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserListMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("丽丽");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	
	/**
	 * @Description: 根据包装对象QueryVo来综合查询(高级查询),这里还使用了动态sql
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserListDynamicSqlMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		//融合了动态sql的高级查询,不设置某个值的话,条件不会拼接在sql中;
		userCustomer.setSex("1");
		//userCustomer.setUsername("丽丽");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	@Test
	public void testFindUserListDynamicSqlForEachMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		//融合了动态sql的高级查询,不设置某个值的话,条件不会拼接在sql中;
		userCustomer.setSex("1");
		//userCustomer.setUsername("丽丽");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(4);
		//将ids通过UserQueryVo传入statement中;
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustomer(userCustomer);
		//发出的sql
		//select * from user WHERE user.sex=? AND ( id=? OR id=? )
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	/**
	 * @Description: 输入映射为Map
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserListMapMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String,String> params = new HashMap<String, String>();
		params.put("name", "丽丽");
		List<UserCustomer> list = userMapper.findUserListMap(params);
		System.out.println(list);
	}
	/**
	 * @Description: 查询结果为一行一列;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserCount() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("丽丽");
		userQueryVo.setUserCustomer(userCustomer);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}
	/**
	 * @Description: 输出结果使用resultMap来进行映射;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void testFindUserByIdResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println(user);
	}
}
