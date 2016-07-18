package cn.itcast.zjw.object.interfaceabstract;

/** 
* @ClassName: InterfaceExplain 
* @Description: 接口的解析,
* 格式特点:
* 	1,接口中常见定义:常量,抽象方法
* 	2,接口中成员都有固定修饰符;
* 		常量的修饰符是public static final;
* 		方法的修饰符是public abstract;
* 接口中的成员都是public,当缺少修饰符的时候,接口会自动进行添加;
* 接口是不可以创建对象的,因为有抽象方法,需要子类实现,子类对接口中的抽象方法全都实现后,子类才可以进行实例化;
* 否则这个子类只能是一个抽象类;
* 接口可以被类多实现,也是java对多继承不支持的转换形式,java支持多实现;
* @author Tom
* @date 2016-2-28 
*/ 
public interface InterfaceExplain {
	public static final double PI = 3.14;
	public void show();
}
interface InterfaceExplainA{
	public abstract void show();
}
/** 
* @ClassName: InterfaceClassExplain 
* @Description:上面接口的实现类;
* @author Tom
* @date 2016-2-28 
*/ 
class InterfaceClassExplain implements InterfaceExplain,InterfaceExplainA{
	public void show() {
		System.out.println(this.toString());
		System.out.println("InterfaceClassExplain.show()");
	}
}
