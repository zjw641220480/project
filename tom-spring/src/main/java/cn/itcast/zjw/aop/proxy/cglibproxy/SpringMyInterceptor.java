package cn.itcast.zjw.aop.proxy.cglibproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 
 * @ClassName:SpringMyInterceptor
 * @Description:使用Spring自己的包进行Cglib代理
 * @Time:2016年8月23日
 * @author:Tom
 */
public class SpringMyInterceptor implements MethodInterceptor{
	//目标方法,但是目标方法不再进行指明;可以重用;
	private Object targetObject;
	//切面,一般是不变的内容;
	private Transaction transaction;
	//初始化上述两个对象
	public SpringMyInterceptor(Object targetObject,Transaction transaction){
		this.targetObject = targetObject;
		this.transaction = transaction;
	}
	/**
	 * 
	 * @MethodName:createProxy
	 * @Description:产生代理对象;使用目标类及目标类的父类
	 * @return
	 * @Time:2016年8月23日上午11:35:48
	 * @author:Tom
	 */
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);//this代表拦截器对象本身
		enhancer.setSuperclass(this.targetObject.getClass());//设置代理类的父类为目标类
		return enhancer.create();
	}
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		this.transaction.openSession();
		method.invoke(this.targetObject, args);
		this.transaction.closeSession();
		return null;
	}

}
