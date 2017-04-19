package cn.itcast.zjw.mapper;

import cn.itcast.zjw.po.User;

/**
 *
 * <p>Title:UserMapper.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年3月26日下午10:13:28
 */
public interface UserMapper {
	public User getUser(String id);
}
