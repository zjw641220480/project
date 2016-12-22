package cn.itcast.zjw.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.zjw.mybatis.dao.BaseDao;
import cn.itcast.zjw.mybatis.dao.UserDao;
import cn.itcast.zjw.mybatis.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	public User findUserById(int id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		User user = sqlSession.selectOne("test.findUserById",1);
		sqlSession.close();
		return user;
	}
	
}
