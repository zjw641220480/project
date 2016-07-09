package cn.itcast.zjw.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 去除List中的重复元素
 * @author Administrator
 *
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
		List<Object> newList = RemoveRepeatElement.singleElement(list);
		System.out.println(newList);
	}
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
