/**
 * @Project: tom-javase @(#) HashSetDemo.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.collection.set;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import cn.itcast.zjw.domain.Person;
/*
 *HashSet:底层数据结构是哈希表,
 *HashSet是如何保证元素唯一性的:通过元素的两个方法,hashCode和equals方法来完成的,
 *如何元素的hashCode值相同,才会判断equals是否为true
 *如果元素的hashCode值不同,不会调用equals; 
 *hashSet保证数据唯一性,但是当两个元素调用==进行地址值进行比较的时候,还是为false;
 *注意:对于判断元素在HashSet容器中是否存在,以及删除容器中元素等操作,依赖的方法是元素的hashCode和equals方法;
 * */
/** 
 * @ClassName: HashSetDemo
 * @Description:HashSet去除容器中的相同元素是依据元素的hashCode和equals两个方法共同作用的,
 * @Time 2016年6月1日 下午5:18:42
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class HashSetDemo {
	@Test
	public void testDemo(){
		Set<Object> hashSet = new HashSet<Object>();
		String s1 = "java1";
		String s2 = "java1";//两个对象的hash值和equals都是一样的
		hashSet.add(s1);
		hashSet.add(s2);
		System.out.println(s1==s2);
		hashSet.add("java2");
		hashSet.add("java3");
		//hashSet中有三个元素
		System.out.println(hashSet);
	}
	@Test
	public void testHash(){
		//对象本身即是重写了hashCode和equals方法,在两个对象进行比较的时候,还是该怎么样就怎么样,
		//只是hashSet集合会把这两个对象当做一个对象来处理,(第二个对象不加入到hashSet)
		Hash hashA = new Hash();
		Hash hashB = new Hash();
		System.out.println(hashA);
		System.out.println(hashB);
		System.out.println(hashA.equals(hashB));//结果为true
		System.out.println(hashA==hashB);//结果竟然还是false
		// 只有当把对象的HashCode方法和equals方法都同时重写之后,HashSet容器才会认为两个对象是一个对象
		Set<Object> hashSet = new HashSet<Object>();
		hashSet.add(hashB);
		hashSet.add(hashA);
		System.out.println(hashSet);
	}
	@Test
	public void testHashSetPerson(){
		HashSet<Person> hashSet = new HashSet<Person>();
		//每次产生的对象,都会先算出来自己的一个hash值
		Person person1 = new Person("lisi",24);
		Person person2 = new Person("lisi",24);
		System.out.println(person1.hashCode());
		System.out.println(person2.hashCode());
		hashSet.add(new Person("lisi",22));
		hashSet.add(new Person("lisi",23));
		hashSet.add(new Person("lisi",24));
		hashSet.add(new Person("lisi",24));
		for(Person p:hashSet){
			System.out.println(p);
		}
	}
}
class Hash{

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

