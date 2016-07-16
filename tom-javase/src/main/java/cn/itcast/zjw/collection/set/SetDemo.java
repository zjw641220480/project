package cn.itcast.zjw.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set元素是无序(存入和取出的顺序不一定一致),元素不可以重复
 * Set集合的功能和Collection是一致的,和Collection中的方法数量是一致的;
 * 	HashSet:底层数据结构是哈希表;java.lang.Object@72ebbf5c这就是hash表
 * 	TreeSet:底层数据结构是二叉树;
 * 	Set集合内部元素之间比较是元素自身的事情,不用考虑什么;
 * 	各个类型的Set集合认为什么样的对象是重复的,这个是容器自己依据自己不同的原理来进行定义的;
 * 		HashSet主要依据hashCode()和equals()方法;
 * 		TreeSet主要依据compareTo()方法;
 * @author TOM
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
