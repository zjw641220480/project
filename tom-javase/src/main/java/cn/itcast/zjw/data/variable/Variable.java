package cn.itcast.zjw.data.variable;

import org.junit.Test;

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
	@Test
	public void testFor(){
		int x = 1;
		/*
		 * for循环的结构,
		 * 1:起始条件,此条件只会运行一次,
		 * 2:循环结束的条件,这个的值必须为false或者是true
		 * 3:步调,这个条件也是可以省略的(当在循环体内部进行步调设置的时候)
		 */
		for(System.out.println("a");x<3;System.out.println("c")){
			System.out.println("Variable.testFor()");
			System.out.println("此时变量x的值为:\t"+x);
			++x;//++x和x++是没有什么区别的;
		}
	}
	/** 
	* @Title: forCompareWhile 
	* @Description:for和while之间的一点小区别的测试
	* @return void
	* @author Tom
	* @date 2016-3-6
	*/ 
	@Test
	public void forCompareWhile(){
		for(int x=0;x<3;x++){
			System.out.println("循环中输出的x的值为:\t"+x);
		}
		//System.out.println(x);编译不通过,因为x的作用域只是在for循环中
		int y = 0;
		while(y<3){
			System.out.println("循环中输出的y的值为:\t"+y);
			y++;
		}
		System.out.println("变量x最终的值为:\t"+y);
	}
}
