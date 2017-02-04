package cn.itcast.zjw.mybatis.primerdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.Person;
import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: MybatisFirst
 * 
 * @Description: 入门程序,mybatis原始dao方式的开发,很多基本的东西,
 * @author Tom
 * @date 2015-12-19
 */
public class MybatisFirst {
	@Test
	// 根据id查询用户信息,得到一条记录结果;
	public void findUserByIdTest() {
		// mybatis全局配置文件的资源路径名;
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建会话工厂,
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到SqlSession;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSeesion操作数据库
		// 第一个参数:映射文件statement的id,等于=命名空间+statement的id
		// 第二个参数:指定和映射文件中所匹配的parameterTyper类型的参数;
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象;
		// selectOne表示只查询出来一条结果
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		// 释放资源;
		sqlSession.close();
	}

	/**
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2015-12-26
	 */
	@Test
	public void findUserByNameTest() {

		// mybatis的全局配置文件地址;
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建会话工厂,
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 通过工厂得到SqlSession;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSeesion操作数据库
		// 第一个参数:映射文件statement的id,等于=命名空间+statement的id
		// 第二个参数:指定和映射文件中所匹配的parameterTyper类型的参数;
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象;
		// list中的User和映射文件中resultType所指定的类型一致;

		 /*这是使用#{}占位符进行模糊查询的例子,自动添加上下单引号; List<User> list =*/
		List<User> list = sqlSession.selectList("test.findUserByName", "%测%");
		//List<User> list = sqlSession.selectList("test.findUserByName", "测");
		System.out.println(list);
		// 释放资源;
		sqlSession.close();
	}

	/**
	 * @param
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2015-12-21
	 */
	@Test
	public void insertUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 插入用户对象
		User user = new User();
		user.setUsername("zhangzan");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.insert("test.insetUser", user);
		// 执行提交事务
		sqlSession.commit();
		// 获取用户信息的主键;mapper配置文件中进行配置
		System.out.println(user.getId() + "============");
		sqlSession.close();
	}
	@Test
	public void testInsertUserUUID(){
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person = new Person();
		//person.setId(UUID.randomUUID().toString());
		person.setAge(13);
		person.setPname("zhangsan");
		sqlSession.insert("test.insertPerson",person);
		//不需要commit就可以得到插入数据的UUID的值
		System.out.println(person.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser", 7);
		// 执行提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 所需要修改的对象
		// 跟hibernate差不多,修改的时候也是需要先查询出来似得;
		User user = new User();
		user.setId(1);
		user.setUsername("更改");
		user.setBirthday(new Date());
		user.setAddress("河南驻马店");
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
}
