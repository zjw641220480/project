package cn.itcast.zjw.mybatis.daodevelop;

import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: UserDao 
 * @Description: dao接口,用户管理,原始dao开发mybatis
 * @author Tom
 * @date 2015-12-21
 */
public interface UserDao {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//添加用户信息;
	public void insertUser(User user) throws Exception; 
	//删除用户信息
	public void deleteUser(int id) throws Exception;
	
}
