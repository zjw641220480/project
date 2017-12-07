package cn.itcast.zjw.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MyInitializingBean.java
 * @Description:容器初始化后运行，在4个类中第三个运行
 * @Time 2017年12月6日
 * @author: Tom
 */
@Component
public class MyInitializingBean implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyInitializingBean.afterPropertiesSet()");
		System.out.println("容器初始化完毕后运行    MyInitializingBean");
	}

}
