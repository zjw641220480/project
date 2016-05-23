package cn.itcast.zjw.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * ClassName: User 
 * @Description: 用户pojo
 * @author Tom
 * @date 2015-12-19
 */
@JsonSerialize(include=Inclusion.NON_NULL)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
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
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public String toString() {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return address;
	}
}
