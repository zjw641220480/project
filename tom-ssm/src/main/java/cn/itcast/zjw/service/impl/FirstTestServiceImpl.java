package cn.itcast.zjw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.mapper.UserMapper;
import cn.itcast.zjw.po.User;
import cn.itcast.zjw.service.FirstTestService;

/**
 *
 * <p>Title:FirstTestServiceImpl.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年3月26日下午10:13:01
 */
@Service("firstTestServiceImpl")
public class FirstTestServiceImpl implements FirstTestService{
	@Resource
	private UserMapper userMapper;

	public User getUser(String id) {
		System.out.println("FirstTestServiceImpl.getUser()");
		return userMapper.getUser(id);
	}
	
}
