package cn.itcast.zjw.controller.test;

import org.springframework.stereotype.Controller;
/**
 *
 * <p>Title:MyTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月10日下午4:50:25
 */
@Controller(value="myTest")
public class MyTest {
	public void show(){
		System.out.println("MyTest.show()");
	}
}
