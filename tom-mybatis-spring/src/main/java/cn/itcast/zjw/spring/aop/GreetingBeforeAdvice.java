package cn.itcast.zjw.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/** 
 * @ClassName:GreetingBeforeAdvice
 * @Description:硬编码方式的前置通知
 * @author TOM
 * @date 2016年5月25日 上午11:18:40
 * @version V1.0.0
 */ 
public class GreetingBeforeAdvice implements MethodBeforeAdvice{
	//在目标方法调用前执行
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println("前置通知执行:\t"+clientName);
	}
	
}
