package cn.itcast.zjw.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @ClassName: WiselySettingsOther.java
 * @Description:读取指定配置文件中的相关属性的值,除了这个类的相关注解外还需要启动类加上@EnableConfigurationProperties注解
 * @Time 2017年9月19日
 * @author: Tom
 */
@ConfigurationProperties(prefix = "wisely",locations = {"classpath:wisely.properties"})  
public class WiselySettingsOther {
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
