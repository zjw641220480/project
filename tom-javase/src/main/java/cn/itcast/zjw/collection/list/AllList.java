package cn.itcast.zjw.collection.list;

/**
 * Collection
 * 	List	元素是有序的,元素可以重复,因为该集合体系有索引,
 * 		ArrayList:底层的数据结构使用的是数组结构,特点在于查询很快,但是增删很慢,线程不同步,
 * 			创建的一个空的ArrayList的初始长度是10,然后当超出容量的时候,每次是增加50%
 * 		LinkedList:底层使用的是链表,特点就是增删很快,查询很慢,
 * 		Vactor:底层是数组数据结构,线程同步,已经是被ArrayList所替代了;
 * 		List集合判断元素是否重复,
 * 			A:对于简单类型也是需要手动进行去重
 * 			B:对于复杂对象类型,更是需要手动专门编写方法依据一定的方法来去重
 * 		使用LinkedList来实现队列和堆栈;
 * 	Set
 * 			元素存放无语,元素不可以重复
 * 		HashSet:底层数据结构是哈希表;java.lang.Object@72ebbf5c这就是hash表
 * 			这种集合判断其内元素是否重复的依据是对象的hash值和equals两个方法;
 * 		TreeSet:底层数据结构是二叉树;
 * 			
 * @author Administrator
 *
 */
public class AllList {

}
