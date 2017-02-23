package cn.itcast.zjw.object;

import org.junit.Test;

/** 
* 类中的成员:
* 1,变量
* 	如果子类中出现非私有的同名成员变量时候,
* 	子类要访问本类中的变量,用this
* 	子类要访问父类中的变量,用super
* 	this代表的是本类对象的引用,
* 	super代表的是父类对象的引用,
* 	变量也同样存在覆盖现象;
* 2,函数
* 	当子类出现和父类一模一样的函数的时候,当子类对象调用该函数,会运行子类函数的内容,如同父类的函数被覆盖似得;
* 	这种情况是函数的另一个特性:重写(覆盖);
* 	子类覆盖父类:
* 		1,必须保证子类权限大于或者等于父类权限,才可以覆盖,否则编译失败,
* 		2,静态只能覆盖静态,
* 3,构造函数
* 对象创建的特点:
* 	在对象第一次进行实例化的时候调用对应的构造方法进行初始化;
* @ClassName: ExtendsExplain 
* @Description:用来演示子父类出现后,类成员的特点
* @author Tom
* @date 2016-2-28 
*/ 

class Fu{
	int num = 4;
	public Fu(){
		System.out.println("父类构造方法运行");
	}
	public void show(){
		System.out.println("父类方法运行");
	}
}
/**
 * 
 * @ClassName:Zi
 * @Description:子类继承父类,并在此类中进行测试
 * @Time:2017年2月23日
 * @author:Tom
 */
public class Zi extends Fu{
	//子类num变量会覆盖父类的num标量
	int num = 5;
	public Zi(){
		System.out.println("子类构造方法运行");
	}
	/**
	 * 
	 * @MethodName:main
	 * @Description:
	 * @Time:2017年2月23日下午5:15:31
	 * @author:Tom
	 */
	@Test
	public void main() {
		Zi zi = new Zi();
		System.out.println("子类的num变量的值\t"+zi.num);
		System.out.println("本(子)类的num变量的值\t"+this.num);
		System.out.println("父类的num变量的值\t"+super.num);
		this.show();
		super.show();
	}
	/**
	 * 
	 * @MethodName:main
	 * @Description:用于演示对象创建的过程:先初始化父类实例,再初始化子类的实例
	 * @param args
	 * @Time:2016年9月1日下午4:09:12
	 * @author:Tom
	 */
	@Test
	public void testDemoCreateObject() {
		new Zi();
	}
	@Override
	public void show() {
		System.out.println("子类方法运行");
	}
	
}
