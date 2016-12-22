package cn.icast.zjw.test.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.mapper.UserMapper;
import cn.itcast.zjw.mybatis.pojo.User;

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
	 * @Description:使用Mapper代理方式的测试
	 * @auther:TOM
	 * @date:2016年12月22日 下午8:45:15
	 */
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

}
