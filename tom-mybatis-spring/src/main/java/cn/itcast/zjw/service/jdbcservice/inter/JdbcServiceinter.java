/**
 * @Project: tom-mybatis-spring @(#) JdbcService.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.service.jdbcservice.inter;

import cn.itcast.zjw.domain.UserCustomer;

/** 
 * @ClassName: JdbcService
 * @Description:
 * @Time 2016年5月24日 下午11:08:30
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public interface JdbcServiceinter {
	public int insertUser(UserCustomer userCustomer);
	public int selectPrimaryKey(UserCustomer userCustomer);
}
