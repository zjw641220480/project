package cn.itcast.zjw.io.propertise;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PropertiesUtil {
	private String path;
	private Properties properties = init(path);
	public Properties init(String path){
		try {
			//在使用main方法进行测试的时候注意其路径的书写方式
			Resource resource = new ClassPathResource(path);
			properties = new Properties();
			properties.load(resource.getInputStream());
			System.out.println(properties.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	public Properties getInstance(String path){
		this.path = path;
		return properties;
	}
	public static void main(String[] args) {
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		Properties properties1 = propertiesUtil.getInstance("log4j.properties");
		//Properties properties2 = propertiesUtil.getInstance("log4j.properties");
		//System.out.println(properties1==properties2);
	}
}
