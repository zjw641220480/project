package cn.itcast.zjw.data.variable;

/** 
* @ClassName: Variable 
* @Description:for和while的一点小区别,
* 1,变量都有自己的作用域,对于for来讲,如果将用于控制循环的增量定义在for语句中,那么该变量只在for语句内有效,
* for语句执行完毕,该变量在内存中被释放;
* 2,for和while可以进行互换,如果需要定义循环增量,用for更合适,
* @author Tom
* @date 2016-3-6 
*/ 
public class Variable {
	public static void main(String[] args) {
		testFor();
		
	}
	public static void testFor(){
		int x = 1;
		for(System.out.println("a");x<3;System.out.println("c")){
			System.out.println("Variable.testFor()");
			x++;
		}
	}
	/** 
	* @Title: forCompareWhile 
	* @Description:for和while之间的一点小区别的测试
	* @return void
	* @author Tom
	* @date 2016-3-6
	*/ 
	public static void forCompareWhile(){
		for(int x=0;x<3;x++){
			System.out.println(x);
		}
		//System.out.println(x);编译不通过,因为x的作用域只是在for循环中
		int y = 0;
		while(y<3){
			System.out.println(y);
			y++;
		}
		System.out.println(y);
	}
}
