package cn.itcast.zjw.base.annotation.dao.impl;

import org.springframework.stereotype.Component;

import cn.itcast.zjw.base.annotation.MyBatis;
import cn.itcast.zjw.base.annotation.dao.UserDao;

/**
 *
 * <p>Title:UserDaoImpl.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月16日上午11:18:51
 */
@MyBatis(name = "userDaoImpl")//自定义注解需要和下面注解一起使用;
@Component
public class UserDaoImpl implements UserDao {
	public String getUser(){
		System.out.println("UserDaoImpl.getUser()");
		return "正确获得User数据";
	}
}
