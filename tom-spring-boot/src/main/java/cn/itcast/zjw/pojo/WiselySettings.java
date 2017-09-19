package cn.itcast.zjw.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @ClassName: WiselySettings.java
 * @Description:读取类路径下application.properties配置文件中的相关属性
 * @Time 2017年9月19日
 * @author: Tom
 */
@ConfigurationProperties(prefix = "wisely2")  
public class WiselySettings {
	private String name;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
