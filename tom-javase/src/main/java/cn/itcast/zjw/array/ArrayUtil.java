package cn.itcast.zjw.array;



/** 
 * @ClassName: ArrayUtil
 * @Description:自己定义的一个数组工具
 * @Time 2016年6月1日 下午3:58:40
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
/** 
 * @ClassName: ArrayUtil
 * @Description:
 * @Time 2016年6月1日 下午4:06:37
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class ArrayUtil {
	/*
	 * 步骤:
	 * 1,定义变量,初始化为数组中任意一个元素即可,
	 * 2,通过循环语句对数组进行遍历,
	 * 3,在遍历过程中定义判断条件,如果遍历到的元素比变量中的元素大,就把这个值赋值给该变量;
	 * */
	/** 
	* @Title: getMax 
	* @Description: 变量为数组中的某个值,获取数组中的最大值,
	* @param arrayInt
	* @return int
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static int getMax_1(int[] arrayInt){
		//初始化为数组中的任意一个元素
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
	public static int getMax_2(int[] arrayInt){
		//初始化为数组中的任意一个角标;
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
	* @Description:数组中元素从小到大排列,内循环一次,最值出现在头角标位置;效率最低的排序方式(选择排序)
	* @param arrayInt 
	* @return void
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static void minToMax(int[] arrayInt){
		int[] array = arrayInt;
		for(int x=0;x<array.length-1;x++){//最后一个直接就是最大的值,不用再进行比较,这里对于减一不用要求特别严格;
			for(int y=x+1;y<array.length;y++){
				if(arrayInt[x]>arrayInt[y]){
					int temp = arrayInt[x];
					arrayInt[x] = arrayInt[y];
					arrayInt[y] = temp;
				}
			}
		}
	}
	/** 
	* @Title: minToMaxBubble 
	* @Description:冒泡排序;小的值在向前移动,大的在往后移动
	* @param arrayInt 
	* @return void
	* @author Tom
	* @date 2016-2-26
	*/ 
	public static void minToMaxBubble(int[] arrayInt){
		for(int x=0;x<arrayInt.length;x++){
			//-x:让每一次比较的元素减少,-1:避免角标越界,这个-1必须存在
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
	private static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
