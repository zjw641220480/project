package cn.itcast.zjw.mybatis.mapper;

import java.util.List;

import cn.itcast.zjw.mybatis.pojo.User;
import cn.itcast.zjw.mybatis.pojo.UserCustomer;
import cn.itcast.zjw.mybatis.pojo.UserQueryVo;

/**
 * 
 * @ClassName:UserMapper
 * @Description:
 * @author: TOM
 * @Time:2016年12月22日
 */
public interface UserMapper {
	//根据id查询用户信息
	public User findUserById(int id);
	//模糊查询,使用到了sql片段,where和if
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo);
	//使用resultMap进行映射;
	public List<UserCustomer> findUserListResultMap(UserQueryVo userQueryVo);
	//批量查询,使用foreach进行循环遍历;
	public List<UserCustomer> findUserListByIds(UserQueryVo userQueryVo);
}
