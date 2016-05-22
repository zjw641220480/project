package cn.itcast.zjw.array;

public class Array {
	static int[] arr;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//三种定义数组的方式
		int[][] intArrayA = new int[5][];
		int[] intArrayB = new int[]{1,2,3,4};
		int[] intArrayC = {1,23,4};
		System.out.println(arr);//null
		System.out.println(intArrayA);//[[I@2e6e1408
		System.out.println(intArrayA[1]);//null
		show(new String[0]);
		testArray();
	}
	public static void show(String[] arr){
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
