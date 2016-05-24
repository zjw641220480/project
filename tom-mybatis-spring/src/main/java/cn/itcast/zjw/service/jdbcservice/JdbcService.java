/**
 * @Project: tom-mybatis-spring @(#) JdbcService.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.service.jdbcservice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.domain.UserCustomer;
import cn.itcast.zjw.jdbcdao.MyJdbcDao;
import cn.itcast.zjw.service.jdbcservice.inter.JdbcServiceinter;

/** 
 * @ClassName: JdbcService
 * @Description:
 * @Time 2016年5月24日 下午11:09:22
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
@Service("jdbcService")
public class JdbcService implements JdbcServiceinter{
	@Resource(name="myJdbcDao")
	private MyJdbcDao myJdbcDao;
	/* (non-Javadoc)
	 * @see cn.itcast.zjw.service.jdbcservice.inter.JdbcServiceinter#insertUser(cn.itcast.zjw.domain.UserCustomer)
	 */
	public int insertUser(UserCustomer userCustomer) {
		return myJdbcDao.insertUser(userCustomer);
	}

}
