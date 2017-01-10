package cn.itcast.zjw.otherobject;

import java.io.IOException;

/**
 * @Description <p>
 *              该类并没有提供构造函数,说明不可以new对象,那么会直接想到该类中的方法都是静态的,
 *              但是发现该类中还有非静态方法,说明该类肯定提供了方法获取本类对象,而且该方法是静态的,并且返回值类型是基本类型;
 *              由这个特点可以知道这个类使用了单例设计模式
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午3:29:54
 * @version V1.3.1
 */
public class MyRunTime {
	public static void main(String[] args) {
		 Runtime runtime = Runtime.getRuntime();
		 try {
			runtime.exec("123");//打开一个exe程序
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("输入输出异常");
		}
		System.out.println("MyRunTime.main()");
	}
}
