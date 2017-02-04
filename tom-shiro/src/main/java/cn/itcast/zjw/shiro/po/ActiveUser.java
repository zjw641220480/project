package cn.itcast.zjw.shiro.po;

import java.io.Serializable;


/** 
 * @ClassName: ActiveUser
 * @Description:用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * @Time 2016年6月29日 下午9:13:48
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class ActiveUser implements Serializable {
	/**
	 * serialVersionUID
	 * @since 1.0.0
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;		//用户id（主键）
	private String usercode;	//用户账号
	private String username;	//用户名称

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
}
