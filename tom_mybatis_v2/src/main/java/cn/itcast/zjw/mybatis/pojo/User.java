﻿package cn.itcast.zjw.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ClassName: User
 * 
 * @Description: 用户基础pojo
 * @author Tom
 * @date 2015-12-19
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 属性名称和数据库表的字段相互对应;
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	private List<Orders> ordersList;

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}
}
