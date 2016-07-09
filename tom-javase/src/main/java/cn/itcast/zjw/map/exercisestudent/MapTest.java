package cn.itcast.zjw.map.exercisestudent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * ClassName: MapTest 
 * @Description: 
 * 每一个学生都有对应的归属地,学生Student,地址String,
 * 学生属性,姓名,年龄,
 * 注意:姓名和年龄相同的视为同一个学生,保证学生的唯一性
 * 1:描述学生
 * 2:定义map容器,将学生作为键,地址作为值存入,
 * 3:获取map集合中的元素
 * @author Tom
 * @date 2016年4月16日
 */
public class MapTest {
	/**
	 * @Description:  姓名和年龄相同的视为同一个学生,保证学生的唯一性
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月16日
	 */
	@Test
	public void testMapStudent(){
		Map<Student,String> students = new HashMap<Student, String>();
		//students.put(new Student("zhangsan",20), "北京");
		//这里为什么在put的时候会认为这个键是已经存在的,对象复写了HashCode()和equals()方法
		//每一次存入的时候都会调用一次HashCode方法,当再次存入发现hashCode的值是一样的时候,再进行equals方法的判断
		students.put(new Student("zhangsan",30), "河南");
		students.put(new Student("lisi",23), "上海");
		students.put(new Student("wangwu",40), "天津");
		students.put(new Student("zhaoliu",32), "深圳");
		
		//第一种取出方式 keySet
		Set<Student> keySet = students.keySet();
		Iterator<Student> iterator = keySet.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			System.out.println(student.toString());
		}
		//第二种取出方式 entrySet
		Set<Entry<Student, String>> entries = students.entrySet();
		Iterator<Entry<Student, String>> iterator2 = entries.iterator();
		while(iterator2.hasNext()){
			Entry<Student, String> entry = iterator2.next();
			Student key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:\t"+key.toString()+"\tvalue:\t"+value);
		}
	}
	@Test
	public void testTreeMapStudent(){
		//Student本身实现了Comparable接口,本身具备比较性
		Map<Student,String> students = new TreeMap<Student, String>(new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				int num = s1.getSname().compareTo(s2.getSname());
				if(num==0){
					//自然排序是从小到大,想要不是自然排序,只需要在每一个判断条件上添加一个负号即可,
					//return -new Integer(s1.getAge()).compareTo(s2.getAge());
					return new Integer(s1.getAge()).compareTo(s2.getAge());
				}
				//return -num;
				return num;
			}
		});
		//下面一个学生不会被存入容器中
		students.put(new Student("lisi",23), "上海");
		//姓名一致选择次比较器,年龄
		students.put(new Student("lisi",34), "上海");
		students.put(new Student("zhangsan",30), "河南");
		students.put(new Student("lisi",23), "上海");
		students.put(new Student("wangwu",40), "天津");
		students.put(new Student("zhaoliu",32), "深圳");
		Set<Student> set = students.keySet();
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
}
