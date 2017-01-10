/**
 * @Project: tom-javase @(#) PropertiesDemo.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.io.propertise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

/**
 * Properties是HashTable的子类,也就是说它具备map集合的特点,而且它里面存储的键值对都是字符串;
 * 是集合中和IO技术相结合的集合容器;
 * 该对象的特点:可以用于键值对形式的配置文件;
 * */
/** 
 * @ClassName: PropertiesDemo
 * @Description:Properties配置文件流的操作
 * @Time 2016年5月21日 下午4:27:39
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class PropertiesDemo {
	@Test
	public void simple(){
		Properties properties = new Properties();
		BufferedReader reader;
		try {
			//在使用main方法进行测试的时候注意其路径的书写方式
			reader = new BufferedReader(new FileReader(new File("src/main/resources/log4j.properties")));
			properties.load(reader);
			Set<String> names = properties.stringPropertyNames();
			for(String name:names){
				System.out.println(name+"\t值:"+properties.getProperty(name));
			}
			System.out.println(properties.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
