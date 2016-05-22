/**
 * @Project: tom-mybatis-spring @(#) UserServiceImpl.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.service;

import cn.itcast.zjw.mapper.UserMapper;
import cn.itcast.zjw.service.inter.UserServiceInter;

/** 
 * @ClassName: UserServiceImpl
 * @Description:
 * @Time 2016年5月22日 下午1:05:45
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class UserServiceImpl implements UserServiceInter{
	private UserMapper userMapper;

	/* (non-Javadoc)
	 * @see cn.itcast.zjw.service.inter.UserServiceInter#testFindUser()
	 */
	public void testFindUser() {
		
	}
	
}
