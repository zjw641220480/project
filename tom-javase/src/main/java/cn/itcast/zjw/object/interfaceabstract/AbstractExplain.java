package cn.itcast.zjw.object.interfaceabstract;

/** 
* @ClassName: AbstractClass 
* @Description:抽象类的描述
* 当多个类出现相同的功能,当时功能主体不同,这也是可以进行向上抽取的,这时,只抽取功能定义,而不抽取功能主体;
* 抽象类的特点:
* 	1,抽象方法一定定义在抽象类中,
* 	2,抽象方法和抽象类都必须被abstract关键字所修饰
* 	3,抽象类不可以使用new来创建对象,因为调用抽象方法没有意义;
* 	4,抽象类中的抽象方法要被使用,只能由子类复写其所有的抽象方法后,建立子类对象调用;如果子类只覆盖了部分抽象方法,那么该子类还是一个抽象类;
* @author Tom
* @date 2016-2-28 
*/ 
public class AbstractExplain {
	public static void main(String[] args) {
		
	}
}
/**
 * 
 * @ClassName:Student
 * @Description:抽象类Student
 * @author TOM
 * @Time: 2016年7月17日上午8:38:10
 */
abstract class Student{
	//把这个方法定义成一个抽象方法;
	public abstract void study();
}
/**
 * 
 * @ClassName:BaseStudent
 * @Description:抽象类Student的实例化一,
 * @author TOM
 * @Time: 2016年7月17日上午8:37:47
 */
class BaseStudent extends Student{
	@Override
	public void study() {
		System.out.println(this.toString());
		System.out.println("BaseStudent.study()");
	}
}
/**
 * 
 * @ClassName:AdvStudent
 * @Description:抽象类Student的实例化二,
 * @author TOM
 * @Time: 2016年7月17日上午8:36:16
 */
class AdvStudent extends Student{
	@Override
	public void study() {
		System.out.println(this.toString());
		System.out.println("AdvStudent.study()");
	}
}

