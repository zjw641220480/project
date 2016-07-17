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
 * @Description: 想要取出Map的值,原理就是讲map的键或者值转换为Set集合
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
		//下面两个方法是取出map中元素的重要方法
		System.out.println(map.values());//[null键对应的值, v1, v2, v3, v4]
		System.out.println(map.keySet());//[null, 1, 2, 3, 4]
		System.out.println(map.entrySet());//[null=null键对应的值, 1=v1, 2=v2, 3=v3, 4=v4]
		System.out.println(map);// 打印的顺序并不是按照添加的顺序,根据键的hash值来打印
	}
	/**
	 * KeySet将map中所有的键存入到Set集合,因为Set具备迭代器,所以可以使用迭代的方式取出所有的键;再根据get方法获取每一个键的值
	 * Map集合的取出原理,将map集合转成Set集合,再通过迭代器取出
	 * @Method:testKeySet
	 * @Description:集合中元素的三种取出方式,(思路都是把map转化为集合set)
	 * @author TOM
	 * @date 2016年7月17日
	 */
	@Test
	public void testKeySet(){
		Map<String, String> map = new HashMap<String, String>();
		// 添加元素
		map.put("1", "v1");
		map.put("2", "v2");
		map.put("3", "v3");
		map.put("4", "v4");
		// 都是需要先把键转化为Set集合;
		// 使用迭代器进行遍历取出
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(map.get(iterator.next()));
		}
		// 使用增强for进行循环遍历取出
		for(String key:map.keySet()){
			System.out.println(map.get(key));
		}
		for(String value:map.values()){
			System.out.println("集合中的每一个键对应的值为:\t"+value);
		}
	}
}
