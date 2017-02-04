/**
 * @Project: tom-mybatis-spring @(#) MyJdbcDao.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.dao.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;







import cn.itcast.zjw.domain.UserCustomer;

/** 
 * @ClassName: MyJdbcDao
 * @Description:
 * @Time 2016年5月24日 下午11:01:21
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
@Repository("myJdbcDao")
public class MyJdbcDao extends BaseJdbcDao{
	/**
	 * @Method: insertUser
	 * @Description:插入用户信息
	 * @param: @param userCustomer 
	 * @return: void
	 * @date 2016年5月24日
	 * @author TOM
	 */
	public int insertUser(UserCustomer userCustomer){
		final String sql = "insert into user(username,sex)values(?,?)";
		Object[] params = new Object[]{userCustomer.getUsername(),userCustomer.getSex()};
		return this.getJdbcTemplate().update(sql, params);
	}
	/** 
	 * @MethodName:selectPrimaryKey
	 * @Desription:自增主键返回
	 * @date:2016年5月25日
	 * @author TOM
	 * @param userCustomer
	 * @return  
	 */
	public int selectPrimaryKey(final UserCustomer userCustomer){
		final String sql = "insert into user(username,sex)values(?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.getJdbcTemplate().update(new PreparedStatementCreator(){
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, userCustomer.getUsername());
				preparedStatement.setString(2, userCustomer.getSex());
				return preparedStatement;
			}}, keyHolder);
		int primaryKey = keyHolder.getKey().intValue();
		return primaryKey;
	}
}
