package cn.itcast.zjw.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 1, add方法的参数类型是Object,以便于接收任意类型的对象
 * 2, 集合中存储的都是对象的引用(地址);
 * 什么是迭代器呢?	其实就是集合的取出元素的方式;
 * List集合特有的迭代器,ListIterator是Iterator的子接口,在迭代时候,不可以通过集合对象的方法操作集合中的元素,
 * 因为会发生ConcurrentModificationException异常,
 * 所以在迭代的时候,只能用迭代器的方法操作元素,但是iterator方法是有限的,只能对元素进行判断取出,删除的操作,如果要进行
 * 其他的操作,如添加,修改,就需要使用其子接口ListIterator,该接口只能通过List集合
 * ClassName: IteratorDemo 
 * @Description: 用于演示集合的迭代器
 * @author Tom
 * @date 2016年4月6日
 */
public class IteratorDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		//获取迭代器用于取出集合中的元素
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("**************");
		IteratorDemo.listIterator(list);
	}
	/**
	 * 
	 * @Method:listIterator
	 * @Description:演示列表迭代器
	 * @author TOM
	 * @date 2016年7月15日
	 * @param list
	 */
	public static void listIterator(List<String> list){
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasNext()){
			Object obj = listIterator.next();
			if(obj.equals("b")){
				listIterator.add("tianjia");
			}
		}
		System.out.println(list);
	}
}
