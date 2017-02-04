package cn.itcast.zjw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.controller.original.ItemController;

/**
 *
 * <p>Title:FirstTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月3日下午2:07:37
 */
public class FirstTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springmvc.xml");
		ItemController itemController = (ItemController) applicationContext.getBean("/itemController.action");
		System.out.println(itemController);
	}
}
