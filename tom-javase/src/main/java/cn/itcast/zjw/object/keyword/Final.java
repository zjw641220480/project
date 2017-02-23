package cn.itcast.zjw.object.keyword;

import java.util.Random;

import org.junit.Test;

import cn.itcast.zjw.domain.Person;
/**
 * 注意:
 * 针对于属性:
 * 	A:被final所修饰的属性,并不一定非要在定义变量的时候便直接初始化,只要保证在使用的时候其是被初始化的即可;
 * 	B:任何final所修饰的属性,都没有了定义的时候给定一个默认值这个特性,都要保证其在使用的时候便已经被初始化即可,但不一定非要在定义的时候初始化
 *  C:属性加final的含义:
 *  	1,变量的引用不能再进行改变;
 *  	2,变量引用的值不能改变,对于引用是一个实例对象的,也一样是符合的;
 * 针对于类:
 * 	类不能再被继承
 * 针对于方法
 * 	方法不能再被子类所重写
 * @ClassName:Final
 * @Description:Final关键字的演示
 * @Time:2016年9月1日
 * @author:Tom
 */
public class Final {
	private static final String staticStr;
	private final String str;
	private final int i;
	//保证在运行的时候其有一个固定的值即可;
	private final int randomI = new Random().nextInt(10);
	private int a ;
	private static Person person = new Person();
	/**
	 * 对static类型的final变量,其若是不在定义时候便初始化的话,也可以使用静态代码块来进行初始化;
	 */
	static{
		staticStr = "s";
	}
	/**
	 * 
	 * @MethodName:Final
	 * @Description:有几个未被初始化的final变量,那么构造函数就需要将这些变量初始化
	 * @author:TOM
	 * @Time: 2016年9月1日
	 * @param s
	 * @param i
	 */
	public Final(String s,int i,String str){
		this.str = s;
		this.i = i;
	}
	public static void main(String[] args) {
		System.out.println(staticStr);
	}
	public void finalMethod(final String strParameter){
		/*
		 * java方法中参数被声明为final,这就意味着无法再方法中更改参数引用所指向的对象,
		 * 同时不能更改参数引用所指向对象的值;所以下面两句话,都不能在编译时期通过; 
		 */
		//strParameter = new String();
		//strParameter = "7";
	}
	/**
	 * 
	 * @MethodName:testMy
	 * @Description:当上述final类型的属性没有在定义的时候便被初始化的话,这里便不能再使用这种方式进行测试,只能使用main方法进行测试
	 * @Time:2016年9月1日下午3:06:03
	 * @author:Tom
	 */
	@Test
	public void myTest(){
		System.out.println(a);
	}
}
