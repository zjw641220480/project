package cn.itcast.zjw.enums;

import org.junit.Test;

/**
 *
 * <p>Title:SimpleEnumTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月23日下午1:39:10
 */
public class SimpleEnumTest {
	/**
	 * 
	 * @MethodName:testSimpleEnum
	 * @Description:简单枚举类的测试
	 * @Time:2017年2月23日下午1:39:33
	 * @author:Tom
	 */
	@Test
	public void testSimpleEnum(){
		//枚举在单独定义或使用的时候,不允许只有右边部分,而不写左边部分;
		SimpleEnum simpleEnum = SimpleEnum.THU;
		System.out.println(simpleEnum.name());
		System.out.println("子类SimpleEnum中ordinal变量的值:\t"+simpleEnum.getOrdinal());
		System.out.println("父类Enum中默认定义的ordinal变量的值:\t"+simpleEnum.ordinal());
	}
}
