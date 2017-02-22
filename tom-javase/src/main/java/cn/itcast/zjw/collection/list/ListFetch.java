package cn.itcast.zjw.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * <p>Title:ListFetch.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月21日下午3:51:48
 */
public class ListFetch {
	List<String> list = new LinkedList<String>();
	//List<String> list = new ArrayList<String>();
	@Before
	public void prepareList(){
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
	}
	/**
	 * 
	 * @MethodName:foreachList
	 * @Description:使用foreach循环来取数
	 * @Time:2017年2月21日下午3:52:23
	 * @author:Tom
	 */
	@Test
	public void foreachList(){
		for(String s:list){
			System.out.println(s);
		}
	}
	/**
	 * 
	 * @MethodName:forList
	 * @Description:使用标准for循环来取数
	 * @Time:2017年2月21日下午3:54:33
	 * @author:Tom
	 */
	@Test
	public void forList(){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	/**
	 * 
	 * @MethodName:iteratorList
	 * @Description:使用迭代器进行遍历List
	 * @Time:2017年2月21日下午3:56:44
	 * @author:Tom
	 */
	@Test
	public void iteratorList(){
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
