package cn.itcast.zjw.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;




import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.domain.Student;

/**
 * Set无序,不可以重复元素,
 * 	HashSet:数据结构是Hash表,线程是非同步的,保证期内元素唯一性的原理:判断元素的hashCode值是否相同,
 * 		如果相同还会继续判断元素的equals方法是否为真,
 * TreeSet:可以对Set集合中的元素进行排序,但是在TreeSet中判断元素是否一致,并不是根据HashCode来实现的;
 * 		但是若要比较元素的equals方法,那么还是需要重写对象的hashCode和equals()方法,底层数据结构是二叉树,
 * 		保证数据唯一性的依据是compareTo方法;和Hash值无关
 * TreeSet排序的第一种方式:让元素自身具备比较性,元素需要实现Compareable接口,覆盖接口中的compareTo方法;
 * 		这种方式也称为元素的自然顺序,或者叫作默认顺序;
 * TreeSet排序的第二种方式:当元素本身不具备比较性的时候,或者具备的比较性不是所需要的,这时就需要让集合自身就别比较性,
 * 		在集合初始化的时候就有了比较方式;
 * 总结:TreeSet排序有两种实现方式:
 * 	一:让TreeSet集合中的元素自身具备比较性;
 * 	二:让TreeSet集合容器本身具备比较性;
 * 	两种排序都存在的时候,以比较器为主,
 * 需求:
 * 往TreeSet集合中存储自定义对象-->学生,并按照学生的年龄进行排序;
 * ClassName: TreeDemo 
 * @Description: TODO
 * @author Tom
 * @date 2016年5月27日
 */
public class TreeSetDemo {
	TreeSet<Object> treeSet = null;
	TreeSetDemo TreeSetDemo = null;
	@Before
	public void myBefore(){
		treeSet = new TreeSet<Object>();
		TreeSetDemo = new TreeSetDemo();
	}
	/** 
	 * @MethodName:testTreeSetSimble
	 * @Desription:TreeSet简单使用,
	 * @date:2016年5月27日
	 * @author TOM  
	 */
	@Test
	public void testTreeSetSimble(){
		treeSet.add("cjava1");
		treeSet.add("ajava2");
		treeSet.add("vjava3");	
		treeSet.add("bjava4");
		System.out.println();
	}
	/** 
	 * 实用TreeSet对Student对象进行排序;
	 * 对象javaBean自身实现Comapreable接口,具备比较性;
	 * @MethodName:testTreeSetStudentCompareTo
	 * @Desription:
	 * @date:2016年5月27日
	 * @author TOM  
	 */
	@Test
	public void testTreeSetStudentCompareTo(){
		treeSet.add(new Student("zhansan",23));
		treeSet.add(new Student("zhansan",25));
		treeSet.add(new Student("zhansan",26));
		treeSet.add(new Student("zhansan",27));
		//这一个元素在比较的时候需要注意
		
		treeSet.add(new Student("test",27,"男"));
		treeSet.add(new Student("test",27,"女"));
		TreeSetDemo.syso(treeSet);
	}
	/** 
	 * 当元素不具备比较性,或者具备的比较性不是所需要的,这时需要让容器自身具备比较性,
	 * 定义了比较器,将比较器对象作为参数传递给TreeSet集合的构造函数
	 * @MethodName:testTreeSetStudent
	 * @Desription:
	 * @date:2016年5月27日
	 * @author TOM  
	 */
	@Test
	public void testTreeSetStudent(){
		treeSet = new TreeSet<Object>(new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Student stu1 = (Student) o1;
				Student stu2 = (Student) o2;
				if(!(o1 instanceof Student) || !(o2 instanceof Student)){
					throw new RuntimeException("所属较对象不一致");
				}
				//return 	stu1.getName().compareTo(stu2.getName());
				int num = stu1.getName().compareTo(stu2.getName());
				//当主要条件一致的时候,判断次要条件
				if(num == 0){
					return Integer.valueOf(stu1.getAge()).compareTo(Integer.valueOf(stu2.getAge()));
				}
				return num;
			}
		});
		treeSet.add(new Student("zhansan001",23));
		treeSet.add(new Student("zhansan003",25));
		treeSet.add(new Student("zhansan002",26));
		treeSet.add(new Student("zhansan004",27));
		//一样是先判断主要条件,然后判断次要条件;
		treeSet.add(new Student("zhansan004",39));
		TreeSetDemo.syso(treeSet);
	}
	
	/** 
	 * @MethodName:syso
	 * @Desription:便利循环打印;
	 * @date:2016年5月27日
	 * @author TOM
	 * @param treeSet  
	 */
	private void syso(TreeSet<Object> treeSet){
		Iterator<Object> iterator = treeSet.iterator();
		while(iterator.hasNext()){
			Student stu = (Student) iterator.next();
			System.out.println(stu.getName()+"\t"+stu.getAge());
		}
	}
}
