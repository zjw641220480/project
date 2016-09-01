package cn.itcast.zjw.enums;

import org.junit.Test;

/**
 * 
 * @ClassName:EnumTest
 * @Description:主要是对枚举在switch中的应用;
 * @author TOM
 * @Time: 2016年7月16日下午5:24:37
 */
public class EnumTest {
	private ColorEnum colorEunm;

	/**
	 * 
	 * @MethodName:testColorEnumSimple
	 * @Description:ColorEnum枚举类的简单测试
	 * @Time:2016年9月1日上午10:20:12
	 * @author:Tom
	 */
	@Test
	public void testColorEnumSimple() {
		System.out.println("获得的GREEN颜色的编号:\t" + ColorEnum.GREEN.getX());
		System.out.println("EnumTest.testColorEnumSimple():\t由于使用枚举类的时候,其内的所有对象都会被初始化,这里做一个标记表明枚举类第一次被初始化完毕");
		// 调用枚举类中对应对象的对应方法;
		ColorEnum.GREEN.method();
		System.out.println(ColorEnum.BLACK);
		// 枚举类中的编号作为switch的选择条件
		switch (ColorEnum.RED.getX()) {
		case 1:
			System.out.println("编号为1的RED被选中");
			break;
		default:
			System.out.println("编号不是1的被选中");
		}
	}
	/**
	 * 
	 * @MethodName:testColorEnum
	 * @Description:ColorEnum枚举类在switch语句中的详细使用;
	 * @Time:2016年9月1日上午10:22:44
	 * @author:Tom
	 */
	@Test
	public void testColorEnum() {
		/**
		 * 也就是说,switch对于枚举类在使用的时候,可以有两种方式,
		 * 	A:使用枚举类中实例对象本身
		 *  B:使用枚举类中被构造函数初始化了的全局变量;
		 */
		// switch中应用枚举的时候,其选择的对象应该是枚举类本身对象,switch的是枚举对象本身
		colorEunm = ColorEnum.BLACK;
		switch (colorEunm) {
		case GREEN:
			System.out.println("GREEN被选中");
			break;
		case RED:
			System.out.println("RED被选中");
			break;
		case BLACK:
			System.out.println("BLACK被选中");
			break;
		default:
			break;
		}
	}
}
