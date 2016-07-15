/**
 * @Project: tom-javase @(#) ArrayUtilTest.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.array;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: ArrayUtilTest
 * @Description:
 * @Time 2016年6月1日 下午4:00:34
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class ArrayUtilTest {
	private static int[] arr;
	/**
	 * @Method: setUp
	 * @Description:
	 * @param: @throws java.lang.Exception 
	 * @return: void
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Before
	public void setUp() throws Exception {
		arr = new int[]{1,33,15,22,56};
		print(arr);
		System.out.println();
	}

	/**
	 * Test method for {@link cn.itcast.zjw.array.ArrayUtil#getMax_1(int[])}.
	 */
	@Test
	public void testGetMax_1() {
		int max = ArrayUtil.getMax_1(arr);
		System.out.println(max);
	}

	@Test
	public void testGetMax_2() {
		int max = ArrayUtil.getMax_2(arr);
		System.out.println(max);
	}
	/**
	 * Test method for {@link cn.itcast.zjw.array.ArrayUtil#minToMax(int[])}.
	 */
	/**
	 * @Method: testMinToMax
	 * @Description:对选择排序方法的测试
	 * @param:  
	 * @return: void
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@Test
	public void testMinToMax() {
		ArrayUtil.minToMax(arr);
		print(arr);
	}

	/**
	 * Test method for {@link cn.itcast.zjw.array.ArrayUtil#minToMaxBubble(int[])}.
	 */
	@Test
	public void testMinToMaxBubble() {
		ArrayUtil.minToMaxBubble(arr);
		print(arr);
	}

	/**
	 * Test method for {@link cn.itcast.zjw.array.ArrayUtil#halfSearch(int[], int)}.
	 */
	@Test
	public void testHalfSearch() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cn.itcast.zjw.array.ArrayUtil#halfSearch_2(int[], int)}.
	 */
	@Test
	public void testHalfSearch_2() {
		fail("Not yet implemented");
	}
	private void print(int[] arr){
		for(int a:arr){
			System.out.print(a+"\t");
		}
	}
}
