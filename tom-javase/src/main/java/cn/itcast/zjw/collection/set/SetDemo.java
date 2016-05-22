package cn.itcast.zjw.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set元素是无序(存入和取出的顺序不一定一致),元素不可以重复
 * Set集合的功能和Collection是一致的,和Collection中的方法数量是一致的;
 * 	HashSet:底层数据结构是哈希表;java.lang.Object@72ebbf5c这就是hash表
 * 	TreeSet:
 * @author Administrator
 *
 */
public class SetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java1");
		set.add("java2");
		set.add("java3");
		set.add("java1");
		System.out.println(set);
	}
	
}
