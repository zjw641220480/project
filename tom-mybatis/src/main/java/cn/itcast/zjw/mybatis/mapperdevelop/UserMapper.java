package cn.itcast.zjw.mybatis.mapperdevelop;

import java.util.List;
import java.util.Map;

import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.domain.UserCustomer;
import cn.itcast.zjw.mybatis.domain.UserQueryVo;

/**
 * ClassName: UserMapper 
 * @Description: mapper代理方式的开发,基础的mapper代理开发,相当于dao接口;
 * @author Tom
 * @date 2015-12-26
 */
public interface UserMapper {
	//根据id查找用户;
	public User findUserById(int id) throws Exception;
	//根据用户名模糊查找用户
	public List<User> findUserByName(String name) throws Exception;
	//插入用户
	public void insertUser(User user) throws Exception;
	//删除用户
	public void deleteUser(int id) throws Exception;
	//更新用户
	public void updateUser(User user) throws Exception;
	
	
	//用户信息的综合查询;
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;
	//输入参数为map;
	public List<UserCustomer> findUserListMap(Map<String,String> params) throws Exception;
	//用户信息综合查询其总数,以便进行分页
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	//利用resultMap进行结果集映射
	public User findUserByIdResultMap(int id) throws Exception;
}
