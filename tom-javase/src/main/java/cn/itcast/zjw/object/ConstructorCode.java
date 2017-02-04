package cn.itcast.zjw.object;

import org.junit.Test;

/** 
* @ClassName: ConstructorCode 
* @Description: 对构造代码快进行说明;
* @author Tom
* @date 2016-2-27 
*/ 
public class ConstructorCode {
	/*
	 * 构造代码快,对象创建之前就运行,而且优先于构造函数执行;
	 * 每创建一个对象,那么该对象都会调用一次构造代码块;
	 * 作用:给对象进行初始化
	 */
	{
		System.out.println("构造代码块运行");
	}
	
	public ConstructorCode(){
		System.out.println("构造方法运行");
	}
	@Test
	public void testConstructorCode(){
		new ConstructorCode();
	}
}
