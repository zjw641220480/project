package cn.itcast.zjw.collection.list;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 使用LinkedList模拟一个堆栈或者队列数据结构,
 * 堆栈:先进后出	如同一个杯子,
 * 队列:先进先出 First In First Out		---->FIFO	如同一个水管,
 * 结果就是堆栈结构的数据类型都需要自己来实现!ArrayList和LinkedList都是队列性质的,先进先出
 * @author Administrator
 *
 */
/**
 * 
 * @ClassName:LinkedListDemo
 * @Description:使用LinkedList模拟一个堆栈或者队列数据结构;
 * @author TOM
 * @Time: 2016年7月15日下午2:16:03
 */
public class LinkedListDemo {
	@Test
	public void testLinkedList() {
		//LinkedList默认也是队列性质的
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("linkedListjava1");
		linkedList.add("linkedListjava2");
		linkedList.add("linkedListjava3");
		linkedList.add("linkedListjava4");
		for(String s:linkedList){
			System.out.println(s);
		}
	}
	@Test
	public void testDuiLie(){
		//队列,先进去的先被打印出来
		DuiLie duiLie = new DuiLie();
		duiLie.myAdd("队列java1");
		duiLie.myAdd("队列java2");
		duiLie.myAdd("队列java3");
		duiLie.myAdd("队列java4");
		while(!duiLie.isEmpty()){
			System.out.println(duiLie.myGet());
		}
	}
	@Test
	public void testDuiZhan(){
		//堆栈,陷进去的后被打印出来
		DuiZhan duiZhan = new DuiZhan();
		duiZhan.myAdd("堆栈java1");
		duiZhan.myAdd("堆栈java2");
		duiZhan.myAdd("堆栈java3");
		duiZhan.myAdd("堆栈java4");
		while(!duiZhan.isEmpty()){
			System.out.println(duiZhan.myGet());
		}
	}
}
/**
 * 队列就是每次添加都是添加first,但是弹出的时候,都是弹出最后一个
 * @author Administrator
 *
 */
class DuiLie{
	private LinkedList<Object> linkedList;
	DuiLie(){
		linkedList = new LinkedList<Object>();
	}
	public void myAdd(Object obj){
		// 把后面进入的依次压入进去
		linkedList.addFirst(obj);
	}
	public Object myGet(){
		// 每次都是弹出最后一个
		return linkedList.removeLast();
	}
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
}
/**
 * 堆栈就是每次添加都是添加first,但是弹出的时候,都是弹出第一个
 * @author Administrator
 *
 */
class DuiZhan{
	private LinkedList<Object> linkedList;
	DuiZhan(){
		linkedList = new LinkedList<Object>();
	}
	public void myAdd(Object obj){
		// 把后面进入的依次压入进去
		linkedList.addFirst(obj);
	}
	public Object myGet(){
		// 每次都是弹出第一个
		return linkedList.removeFirst();
	}
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
}