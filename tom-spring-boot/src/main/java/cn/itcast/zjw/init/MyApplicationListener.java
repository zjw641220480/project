package cn.itcast.zjw.init;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 
 * @ClassName: MyApplicationListener.java
 * @Description:容器启动完成后开始运行，在四个类中最后一个运行
 * @Time 2017年12月6日
 * @author: Tom
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			System.out.println("MyApplicationListener.onApplicationEvent()");
			System.out.println("容器启动完成后运行");
		}
	}

}
