/**
 * @Project: tom-mybatis-spring @(#) JdbcDao.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.dao.jdbcdao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

/** 
 * @ClassName: JdbcDao
 * @Description:
 * @Time 2016年5月24日 下午10:52:41
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class BaseJdbcDao {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
}
