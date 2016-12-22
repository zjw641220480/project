package cn.itcast.zjw.mybatis.dao;

import cn.itcast.zjw.mybatis.pojo.User;

/**
 * 
 * @ClassName:UserDao
 * @Description:
 * @author: TOM
 * @Time:2016年12月21日
 */
public interface UserDao {
	public User findUserById(int id);
	
}
