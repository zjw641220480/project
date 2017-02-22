package cn.itcast.zjw.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * <p>Title:SetFetch.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月21日下午3:58:23
 */
public class SetFetch {
	Set<String> set = new HashSet<String>();
	//Set<String> set = new TreeSet<String>();
	@Before
	public void prepareSet(){
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
	}
	/**
	 * 
	 * @MethodName:foreachSet
	 * @Description:使用标准foreach进行遍历
	 * @Time:2017年2月21日下午3:59:40
	 * @author:Tom
	 */
	@Test
	public void foreachSet(){
		for(String s:set){
			System.out.println(s);
		}
	}
	/**
	 * 
	 * @MethodName:forSet
	 * @Description:不能使用标准for循环对Set集合进行遍历,set集合不能根据下标进行取值
	 * @Time:2017年2月21日下午4:01:39
	 * @author:Tom
	 */
	@Test
	public void forSet(){
		for(int i=0;i<set.size();i++){
			System.out.println(set);
		}
	}
	/**
	 * 
	 * @MethodName:iteratorSet
	 * @Description:使用迭代器进行遍历Set集合
	 * @Time:2017年2月21日下午4:03:50
	 * @author:Tom
	 */
	@Test
	public void iteratorSet(){
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
