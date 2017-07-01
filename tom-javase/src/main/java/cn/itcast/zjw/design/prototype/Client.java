package cn.itcast.zjw.design.prototype;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Client {
	/**
	 * 
	 * @MethodName:main
	 * @Description:基本测试,只是测试复制基本数据类型时候的结果
	 * @param args
	 * @throws CloneNotSupportedException
	 * @Time: 2017年7月1日 下午7:01:35
	 * @author: TOM
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		PersonPrototype p1=new PersonPrototype();
        p1.setName("汤高");
        p1.setAge(20);

//      Person p2=p1;//地址相同  只是把引用给了p2 指向同一个地址
//      System.out.println(p1==p2);//true
        PersonPrototype p2=(PersonPrototype) p1.clone();
        //拷贝  地址不同了 指向不同的地址
        System.out.println("前后地址相同吗:  "+(p2==p1));
        System.out.println("两个对象的hash值:\t"+p1.hashCode()+"\t"+p2.hashCode());
        System.out.println("输出p1:" +p1.getName()+"\t"+p1.getAge());
        System.out.println("输出p2:" +p2.getName()+"\t"+p2.getAge());

        //修改拷贝后的对象的属性值,结果中,p2对象中的String类型数据也发生了改变,
        //可知对于基本类型和String类型的数据前后都是指向不同的地址空间,改变一个不会影响其他的对象
        p2.setName("周思远");
        p2.setAge(19);
        System.out.println("输出p1:" +p1.getName()+"\t"+p1.getAge());
        System.out.println("输出p2:" +p2.getName()+"\t"+p2.getAge());
	}
	@Test
	public void testListAndObject() throws CloneNotSupportedException{
		PersonPrototype p1 = new PersonPrototype();
		List<String> friends=new ArrayList<String>();
        friends.add("汤小高");
        friends.add("周小思");
        p1.setFriends(friends);
        
        School school=new School();
        school.setsName("清华");
        p1.setSchool(school);
        
        //p1克隆之后,才对School对象进行赋值的时候,p2中不能复制到School对象的引用
        PersonPrototype p2 = (PersonPrototype) p1.clone();
        System.out.println(p1.getFriends());
        System.out.println(p2.getFriends());
        
        friends.add("TSY");
        p1.setFriends(friends);
        System.out.println(p1.getFriends());
        System.out.println(p2.getFriends());
        
        //两个list的hashCode值一样,结果表明克隆之后,对象中的List没有同时进行克隆,两个对象中的list指向同一个引用;
        System.out.println(p1.getFriends().hashCode());
        System.out.println(p2.getFriends().hashCode());
        System.out.println("------------------------");
       //当p1中的school在这里进行赋值的时候,p2中由于在上面被复制,不能获得引用,第二句输出为null
        System.out.println(p1.getSchool());//北大
        System.out.println(p2.getSchool());//北大

	}
}
