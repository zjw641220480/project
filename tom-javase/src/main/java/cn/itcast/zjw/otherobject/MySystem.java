package cn.itcast.zjw.otherobject;

import java.util.Properties;

/**
 * Class <code>MySystem</code> 
 * 
 * @Time 2016年5月18日 下午2:35:15
 * @author: TOM
 * @version 1.0.0 ,2016年5月18日
 * @since  1.6
 */
public class MySystem {
	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		Properties properties = System.getProperties();
		//因为Properties是HashTable的子类,也就是Map集合的一个子类对象;
		//那么可以通过map的方法来取出集合中的属性
		//该集合中存储的都是字符串,没有泛型定义
		//使用增强for进行循环遍历取出
		for(Object key:properties.keySet()){
			System.out.println(key+"\t"+properties.get(key).toString());
		}
		Long endTime =System.currentTimeMillis();
		System.out.println(startTime);
		System.out.println(endTime);
	}
}
