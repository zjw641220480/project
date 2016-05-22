package cn.itcast.zjw.object;

/** 
* @ClassName: ExtendsExplain 
* @Description:用来演示子父类出现后,类成员的特点
* 类中的成员:
* 1,变量
* 	如果子类中出现非私有的同名成员变量时候,
* 	子类要访问本类中的变量,用this
* 	子类要访问父类中的变量,用super
* 	this代表的是本类对象的引用,
* 	super代表的是父类对象的引用,
* 2,函数
* 	当子类出现和父类一模一样的函数的时候,当子类对象调用该函数,会运行子类函数的内容,如同父类的函数被覆盖似得;
* 	这种情况是函数的另一个特性:重写(覆盖);
* 	子类覆盖父类:
* 		1,必须保证子类权限大于或者等于父类权限,才可以覆盖,否则编译失败,
* 		2,静态只能覆盖静态,
* 3,构造函数
* @author Tom
* @date 2016-2-28 
*/ 
public class ExtendsExplain {
	public static void main(String[] args) {
		Zi zi = new Zi();
		System.out.println(zi.num);
	}
}
class Fu{
	int num = 4;
}
class Zi{
	int num = 5;
}
