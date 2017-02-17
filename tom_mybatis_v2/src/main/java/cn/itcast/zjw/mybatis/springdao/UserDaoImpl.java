package cn.itcast.zjw.mybatis.springdao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.zjw.mybatis.dao.UserDao;
import cn.itcast.zjw.mybatis.pojo.User;

/**
 *
 * <p>Title:UserDaoImpl.java</p>
 * <p>Description:和Spring整合后的原始dao开发</p>
 * @author TOM
 * @date 2017年2月17日下午4:43:32
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	public User findUserById(int id) {
		User user = this.getSqlSession().selectOne("cn.itcast.zjw.mybatis.mapper.UserMapper.findUserById", 1);
		return user;
	}
	
}
