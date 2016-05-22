package cn.itcast.zjw.array;

import java.util.Arrays;


public class ArrayUtil {
	public static void main(String[] args) {
		int[] arrayInt = new int[]{16,3,5,4,8,7,9};
		Arrays.sort(arrayInt);
		System.out.println(arrayInt[3]);
		System.out.println(ArrayUtil.halfSearch(arrayInt, 7));
	}
	/** 
	* @Title: getMax 
	* @Description: 获取数组中的最大值,
	* @param arrayInt
	* @return int
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static int getMax_1(int[] arrayInt){
		int max = arrayInt[0];
		for(int i=1;i<arrayInt.length;i++){
			if(arrayInt[i]>max){
				max = arrayInt[i];
			}
		}
		return max;
	}

	/** 
	* @Title: getMax_2 
	* @Description: 利用角标的方式来获得数组中的最大值;
	* @param arrayInt
	* @return int
	* @author Tom
	* @date 2016-2-26
	*/ 
	@SuppressWarnings("unused")
	private int getMax_2(int[] arrayInt){
		int max = 0;
		for(int i=1;i<arrayInt.length;i++){
			if(arrayInt[i]>arrayInt[max]){
				max = i;
			}
		}
		return arrayInt[max];
	}
	/** 
	* @Title: minToMax 
	* @Description:数组中元素从小到大排列,内循环一次,最值出现在头角标位置;
	* @param arrayInt 
	* @return void
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static void minToMax(int[] arrayInt){
		int[] array = arrayInt;
		for(int x=0;x<array.length-1;x++){
			for(int y=x+1;y<array.length;y++){
				if(array[x]>array[y]){
					int temp = array[x];
					array[x] = array[y];
					array[y] = temp;
				}
			}
		}
	}
	/** 
	* @Title: minToMaxBubble 
	* @Description:冒泡排序;
	* @param arrayInt 
	* @return void
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static void minToMaxBubble(int[] arrayInt){
		for(int x=0;x<arrayInt.length;x++){
			for(int y=0;y<arrayInt.length-x-1;y++){
				if(arrayInt[y]>arrayInt[y+1]){
					int temp = arrayInt[y];
					arrayInt[y] = arrayInt[y+1];
					arrayInt[y+1] = temp;
				}
			}
		}
	}
	/** 
	* @Title: halfSearch 
	* @Description: 折半查找,前提是数组必须有序;
	* @param arr
	* @param key
	* @return 
	* @return int
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static int halfSearch(int[] arr,int key){
		int min,max,mid;
		min = 0;
		max = arr.length-1;
		mid = (min+max)/2;
		while(arr[mid]!=key){
			if(key>arr[mid]){
				min = mid+1;
			}else if(key<arr[mid]){
				max = mid-1;
			}
			if(min>max){
				return -1;
			}
			mid = (min+max)/2;
		}
		return mid;
	}
	/** 
	* @Title: halfSearch_2 
	* @Description: 折半查找的第二种方式;
	* @param arr
	* @param key
	* @return int
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static int halfSearch_2(int[] arr,int key){
		int min,max,mid;
		min = 0;
		max = arr.length-1;
		while(min<=max){
			mid = (min+max)/2;
			if(key>arr[mid]){
				min = mid+1;
			}else if(key<arr[mid]){
				max = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}
