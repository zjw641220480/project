package cn.itcast.zjw.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 1.添加, put(K key, V value) putAll(Map<? extends K,? extends V>) 
 * 2,删除, clear() remove(Object key) 
 * 3,判断, containsKey(Object key) containsValue(Object value) isEmpty(); 
 * 4,获取, get(Object key) size() values() entrySet() keySet() 
 * Map 
 * 	|--HashTable,底层是Hash表数据结构,不可以存入null值;该集合是线程同步的,
 * 	|--HashMap,底层是Hash表数据结构,并允许使用null键,null值,
 * 	|--TreeMap,底层是二叉树数据结构,线程不同步,可以用于给map集合中的键进行排序;和Set很像,其实Set底层就是使用的Map集合
 * ClassName: MapDemo
 * 
 * @Description: TODO
 * @author Tom
 * @date 2016年4月13日
 */
public class MapDemo {
	@Test
	public void testMapSimble() {
		//HashMap中null是可以作为键来使用的
		Map<String, String> map = new HashMap<String, String>();
		// 添加元素
		map.put("1", "v1");
		map.put("2", "v2");
		map.put("3", "v3");
		map.put("4", "v4");
		map.put(null, "null键对应的值");
		System.out.println(map.containsKey("1"));
		System.out.println(map.containsValue("v1"));
		System.out.println(map.values());//打印的是一个数据
		System.out.println(map);// 打印的顺序并不是按照添加的顺序,根据键的hash值来打印
	}
	/**
	 * KeySet将map中所有的键存入到Set集合,因为Set具备迭代器,所以可以使用迭代的方式取出所有的键;再根据get方法获取每一个键的值
	 * Map集合的取出原理,将map集合转成Set集合,再通过迭代器取出
	 * @Description: TODO   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月14日
	 */
	@Test
	public void testKeySet(){
		Map<String, String> map = new HashMap<String, String>();
		// 添加元素
		map.put("1", "v1");
		map.put("2", "v2");
		map.put("3", "v3");
		map.put("4", "v4");
		//使用迭代器进行遍历取出
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(map.get(iterator.next()));
		}
		//使用增强for进行循环遍历取出
		for(String key:map.keySet()){
			System.out.println(map.get(key));
		}
	}
}
