package cn.itcast.zjw.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MyApplicationContextAware.java
 * @Description:所有的Bean已经初始化完毕后，开始运行，在四个类中第二个运行
 * @Time 2017年12月6日
 * @author: Tom
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("MyApplicationContextAware.setApplicationContext()");
		System.out.println("SpringBoot容器开始启动,可以先行启动第三方框架：如Jdon框架");
	}
	
}
