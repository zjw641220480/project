package cn.icast.zjw.test.sqlsession;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.pojo.User;

/**
 * 
 * @ClassName:FirstTest
 * @Description:第一个测试类,直接使用sqlSession对数据库进行增删改查;
 * @author: TOM
 * @Time:2016年12月17日
 */
public class FirstTestSqlSession {
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
	 * @Method:testOriginal
	 * @Description:初步测试，直接使用sqlSession来与数据库进行交互，没有dao和mapper的任何信息
	 * @auther:TOM
	 * @date:2016年12月17日 下午3:25:30
	 */
	@Test
	public void testOriginal(){
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById",1);
		System.out.println("FirstTest.testOriginal()");
		System.out.println(user);
		session.close();
	}
	/**
	 * 
	 * @Method:testSelectList
	 * @Description:使用#方式进行模糊查询
	 * @auther:TOM
	 * @date:2016年12月17日 下午3:27:16
	 */
	@Test
	public void testSelectListUseJingHao(){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("test.findUserByNameUseJingHao","%zang%");
		System.out.println(users);
		session.close();
	}
	/**
	 * 
	 * @MethodName:testSelectListUse$
	 * @Description:使用$方式进行模糊查询
	 * @Time:2017年2月4日下午3:39:38
	 * @author:Tom
	 */
	@Test
	public void testSelectListUse$() {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("test.findUserByNameUse$","zhang");
		System.out.println(users);
		session.close();
	}
	/**
	 * 
	 * @Method:testInsert
	 * @Description:插入一个,两种方式解决如何当对象中属性为空的时候正确的插入数据;
	 * @auther:TOM
	 * @date:2016年12月17日 下午8:43:04
	 */
	@Test
	public void testInsert(){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("lisi");
		user.setBirthday(new Date());
		user.setSex("1");
		session.insert("test.insetUser",user);
		session.commit();
		session.close();
	}
	/**
	 * 
	 * @Method:testInsertPrimaryKey
	 * @Description:获取刚刚插入的主键值
	 * @auther:TOM
	 * @date:2016年12月18日 下午1:37:45
	 */
	@Test
	public void testInsertPrimaryKey(){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("lisi");
		user.setAddress("驻马店");
		user.setBirthday(new Date());
		user.setSex("1");
		session.insert("test.insetUser",user);
		session.commit();
		System.out.println("刚刚插入的主键值为\t"+user.getId());
		session.close();
	}
	/**
	 * 
	 * @Method:testDelete
	 * @Description:删除一个
	 * @auther:TOM
	 * @date:2016年12月17日 下午9:29:33
	 */
	@Test
	public void testDelete(){
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUser", 11);
		session.commit();
		session.close();
	}
	/**
	 * 
	 * @Method:testUpdate
	 * @Description:修改一个,修改的时候也会出现对象值为空而报列类型错误;
	 * @auther:TOM
	 * @date:2016年12月17日 下午9:48:15
	 */
	@Test
	public void testUpdate(){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(1);
		user.setBirthday(new Date());
		user.setUsername("李四");
		session.delete("test.updateUser", user);
		session.commit();
		session.close();
	}
	
}
