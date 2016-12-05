package cn.itcast.zjw.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.domain.Student;

/**
 * 
 * @ClassName:ListSort
 * @Description:集合的排序,不论是集合自身,还是借助Collections工具类,都需要在sort方法中实现Comparator接口
 * @author: TOM
 * @Time:2016年12月5日
 */
public class ListSort {
	List<Student> students = new ArrayList<Student>();

	@Before
	public void ready() {
		for (int i = 0; i < 1000; i++) {
			Student student = new Student();
			int random = new Random().nextInt(10);
			student.setAge(random);
			if (random % 2 == 0) {
				student.setName("张三");
				student.setSex("男");
			} else {
				student.setName("李四");
				student.setSex("女");
			}
			students.add(student);
		}
	}

	/**
	 * 
	 * @Method:testSortV6
	 * @Description:jdk6.0版本的排序
	 * @auther:TOM
	 * @date:2016年12月5日 下午10:01:40
	 */
	@Test
	public void testSortV6() {
		long start = System.currentTimeMillis();
		Collections.sort(students, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				int num = 0;
				num = Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
				return num;
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		for(Student s:students){
			System.out.println("name\t"+s.getName()+"\tage\t"+s.getAge());
		}
	}
	/**
	 * 
	 * @Method:testSortV8
	 * @Description:jdk8.0版本的排序
	 * @auther:TOM
	 * @date:2016年12月5日 下午10:24:22
	 */
	@Test
	public void testSortV8(){
		long start = System.currentTimeMillis();
		students.sort(new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				int num = 0;
				num = Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
				return num;
			}
		});
		long end = System.currentTimeMillis();
		System.out.println("排序所花费时间为\t"+(end-start));
		for(Student s:students){
			System.out.println("name\t"+s.getName()+"\tage\t"+s.getAge());
		}
	}
}
