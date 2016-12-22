package cn.itcast.zjw.mybatis.mapper;

import cn.itcast.zjw.mybatis.pojo.User;

/**
 * 
 * @ClassName:UserMapper
 * @Description:
 * @author: TOM
 * @Time:2016年12月22日
 */
public interface UserMapper {
	public User findUserById(int id);
}
