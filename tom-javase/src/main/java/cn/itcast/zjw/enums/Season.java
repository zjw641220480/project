package cn.itcast.zjw.enums;
/**
 * @ClassName:Season
 * @Description:一个标准的枚举类
 * @Time:2016年9月1日
 * @author:Tom
 */
public enum Season {
	//下面是这个枚举类中可以直接使用的实例化了的枚举对象,也即Season对象;
	//创建了四个Season对象
	SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4),DEFAULT;
	//枚举自身的私有的构造器,每一个类型实际就是一个实例化了的枚举对象
	private Season(int x){
		this.x=x;
		System.out.println(this.toString());
		System.out.println("Season.Season()");
		System.out.println("枚举中指明每一个枚举实例编号的构造器运行");
	}
	private Season(){
		System.out.println("枚举类中的默认构造器");
	}
	//通过构造器为参数赋值,在switch中也是可以使用的
	private int x;
	public int getX() {
		return x;
	}
}
