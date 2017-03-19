package cn.itcast.zjw.shiro.po;

import java.io.Serializable;

/**
 *
 * <p>Title:ActiveUser.java</p>
 * <p>Description:用于记录用户身份信息</p>
 * @author TOM
 * @date 2017年3月19日下午8:03:08
 */
public class ActiveUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5824247818276688079L;
	private String userId;//用户id
	private String userCode;//用户账号
	private String userName;//用户名称
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
