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
 * @Description: mapper����ʽ�Ŀ����Ĳ���,������mapper������,�������˻���Ĳ���
 * @author Tom
 * @date 2016-1-5
 */
public class UserMapperTest {
	private static SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		// ����sqlSessionFactory
		// mybatisȫ�������ļ���ַ;
		String resource = "SqlMapConfig.xml";
		// �õ�ȫ�������ļ���;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����,����mybatisȫ�������ļ���Ϣ(������ʽ);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// ����һ��UserMapper�������;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserById(2);
		System.out.println(user);
	}

	@Test
	public void testFindUserByIdResultMap() throws Exception {
		// ����һ��UserMapper�������;
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
		// ������װ����,���ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		// �������ʹ���˶�̬sql,���������ĳ��ֵ,�������������sql��
		// userCustomer.setSex("1");
		// userCustomer.setUsername("zhangzan");
		// ������id
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
		// ������װ����,���ò�ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("zhangzan");
		userQueryVo.setUserCustomer(userCustomer);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count + "\t****************");
		// mapper����Ҳ����Ҫ�ֶ��ر�sqlSession?????
		sqlSession.close();
	}

	// һ���������
	@Test
	public void testCache1() throws Exception {
		// �����������
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// ��һ�η�������,��ѯidΪ1���û�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1 + "\t =========================");
		// ���SqlSessionȥִ��commit����(ִ����,ɾ,�ĵĲ���),�����sqlSession�е�һ������,
		// ��������Ŀ����Ϊ���û����еĴ洢��������Զ�����µ���Ϣ,�������,

		// ����user1�������;
		user1.setUsername("һ������");
		userMapper.updateUser(user1);
		// ִ��commit�������ύ����,�����������
		sqlSession.commit();
		// �ڶ��η�������,Ҳ�ǲ�ѯidΪ1���û���Ϣ
		User user2 = userMapper.findUserById(1);
		System.out.println(user2 + "\t =========================");
		sqlSession.close();
	}
	//��������Ĳ���
	@Test
	public void testCatch2()throws Exception {
		//���ѵ�ǰstatement����Ϊ���ö�������,
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		//��һ�η�������,��ѯidΪ1���û�,
		User user1 = userMapper1.findUserById(2);
		System.out.println(user1);
		//����ر�,��sqlSession�е�����д��������������,
		sqlSession1.close();
		//ʹ��SqlSession3ִ��commit����,
		User user3 = userMapper3.findUserById(2);
		user3.setUsername("��������");
		userMapper3.updateUser(user3);
		//ִ���ύ,���UserMapper�±ߵĶ�������,
		sqlSession3.commit();
		sqlSession3.close();
		User user2 = userMapper2.findUserById(2);
		System.out.println(user2);
		sqlSession2.close();
		System.out.println("UserMapperTest.testCatch2()");
	}
}
