package cn.itcast.zjw.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.itcast.zjw.domain.Person;

/**
 * 将自定义对象作为元素存到ArrayList集合中,并去除重复元素,
 * 比如存人对象,同姓名,同年龄,视为同一个人,为重复元素,
 * 思路
 * 	1:对人进行描述,将数据封装进一个对象
 * 	2:定义容器,将人存入
 * 	3:取出
 * @author Administrator
 *
 */
public class AllRemoveRepeatElement {
	public static void main(String[] args) {
		//List集合并不会去理会存入的是不是一个对象,里面存的只是对象的引用地址而已;
		//ArrayList默认是队列结构的,先进先出;
		List<Object> arrayList = new ArrayList<Object>();
		Person person = new Person("lisi", 33);
		arrayList.add(person);
		arrayList.add(person);
		arrayList.add(new Person("zhangsan",33));
		arrayList.add(new Person("zhangsan",32));
		arrayList.add(new Person("zhangsan",31));
		arrayList.add(new Person("zhangsan",33));
		arrayList.add(new Person("zhangsan",33));
		syso(arrayList);
		List<Object> newList = AllRemoveRepeatElement.singleElement(arrayList);
		syso(newList);
	}
	/**
	 * 手动去除List集合中的重复对象
	 * @param list
	 * @return
	 */
	private static ArrayList<Object> singleElement(List<Object> list){
		ArrayList<Object> newList = new ArrayList<Object>();
		Iterator<Object> iterator = list.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			//每一次都是需要再判断一下新集合中是否具有重复的元素
			if(!newList.contains(obj)){
				newList.add(obj);
			}
		}
		return newList;
	}
	private static void syso(List<Object> list){
		Iterator<Object> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
}