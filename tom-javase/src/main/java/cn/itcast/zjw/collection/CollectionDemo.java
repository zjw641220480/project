package cn.itcast.zjw.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: CollectionDemo
 * @Description:add方法的参数类型是Object,以便于接收任意类型的对象, 2,集合中存储的都是对象的引用(或者说是地址)
 * @author Tom
 * @date 2016-3-6
 */
public class CollectionDemo {
	public static void main(String[] args) {
		method_get();
	}
	/** 
	* @Title: method_get 
	* @Description:迭代器的使用,
	* 什么是迭代器,其实就是集合的取出元素的方式,
	* @return void
	* @author Tom
	* @date 2016-3-6
	*/ 
	public static void method_get(){
		List list = new ArrayList<String>();
		Collection<String> collection = new ArrayList<String>();
		collection.add("java01...");
		collection.add("java02...");
		collection.add("java03...");
		collection.add("java04...");
		//下面是集合的三种取出方式
		//获取迭代器,用于取出集合中的元素
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
		//利用for循环类实现迭代
		for(Iterator<String> it = collection.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
	/** 
	* @Title: base_method_2 
	* @Description: 取交集
	* @return void
	* @author Tom
	* @date 2016-3-6
	*/ 
	public static void base_method_2() {
		Collection<String> collection_1 = new ArrayList<String>();
		collection_1.add("java01...");
		collection_1.add("java02...");
		collection_1.add("java03...");
		collection_1.add("java04...");
		
		Collection<String> collection_2 = new ArrayList<String>();
		collection_2.add("java01...");
		collection_2.add("java02...");
		collection_2.add("java05...");
		collection_2.add("java06...");
		//取交集,第一个集合中,只会保留和第二个集合中相同的元素
		collection_1.retainAll(collection_2);
	}

	/** 
	* @Title: base_method_1 
	* @Description: 集合基本操作
	* @return void
	* @author Tom
	* @date 2016-3-6
	*/ 
	public static void base_method_1() {
		// 创建 一个集合容器,使用Collection接口的子类,ArrayList
		Collection<String> collection = new ArrayList<String>();
		// 1,向集合中添加元素
		collection.add("java01...");
		collection.add("java02...");
		collection.add("java03...");
		collection.add("java04...");
		// 打印原集合
		System.out.println("原集合\t" + collection);
		// 3,删除元素
		collection.remove("java02...");
		// 2,获取个数,集合长度,
		System.out.println("此集合的长度为:\t" + collection.size());
		// 4,清空集合
		// collection.clear();
		// 5判断元素是否在此集合中存在
		System.out.println("判断元素java03...是否存在:"
				+ collection.contains("java03..."));
		// 6,集合是否为空
		System.out.println("集合是否为空?\t" + collection.isEmpty());
		System.out.println("新集合\t" + collection);
	}
}
