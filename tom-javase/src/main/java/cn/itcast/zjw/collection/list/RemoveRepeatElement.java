package cn.itcast.zjw.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @ClassName:RemoveRepeatElement
 * @Description:简单的去除List中的重复元素
 * @author TOM
 * @Time: 2016年7月15日下午2:19:46
 */
public class RemoveRepeatElement {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("2");
		list.add("2");
		list.add("3");
		System.out.println(list);
		System.out.println("去除List中重复元素后的集合内容");
		List<Object> newList = RemoveRepeatElement.singleElement(list);
		System.out.println(newList);
	}
	/**
	 * 
	 * @Method:singleElement
	 * @Description:用来去除参数List中的重复元素,返回一个新的List集合
	 * @author TOM
	 * @date 2016年7月15日
	 * @param list
	 * @return
	 */
	private static ArrayList<Object> singleElement(List<String> list){
		ArrayList<Object> newList = new ArrayList<Object>();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			if(!newList.contains(obj)){
				newList.add(obj);
			}
		}
		return newList;
	}
}
