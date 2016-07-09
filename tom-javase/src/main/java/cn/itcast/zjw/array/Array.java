﻿package cn.itcast.zjw.array;

public class Array {
	private static int[] arr;
	/**
	 * @Method: main
	 * @Description:数组的三种定义方式,
	 * @param: @param args 
	 * @return: void
	 * @date 2016年6月1日
	 * @author TOM
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//三种定义数组的方式,数组的定义是不需要小括号的,
		int[][] intArrayA = new int[5][];
		int[] intArrayB = new int[]{1,2,3,4};
		int[] intArrayC = {1,23,4};
		System.out.println(arr);//null
		System.out.println(intArrayA);//[[I@2e6e1408
		System.out.println(intArrayA[1]);//null
		show(new String[0]);
		testArray();
	}
	private static void show(String[] arr){
		System.out.println("Array.show()");
	}
	public static void testArray(){
		//数组长度为0,这样会出现数组角标越界的异常
		@SuppressWarnings("unused")
		String[] arrs = new String[0];
		/*arrs[0] = "11";
		System.out.println(arrs[0]);*/
	}
}
