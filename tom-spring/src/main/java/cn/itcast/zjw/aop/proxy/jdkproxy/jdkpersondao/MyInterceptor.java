package cn.itcast.zjw.aop.proxy.jdkproxy.jdkpersondao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 
 * @ClassName:MyInterceptor
 * @Description:产生代理类的拦截器,
 * @Time:2016年8月17日
 * @author:Tom
 */
public class MyInterceptor implements InvocationHandler{
	//目标方法,但是目标方法不再进行指明;可以重用;
	//而且这里更好的是使用String类型,直接是一个类的路径,然后使用class.forName来进行加载
	//然后获取类的对象,
	private Object targetObject;
	//切面,一般是不变的内容;
	private Transaction transaction;
	//初始化上述两个对象
	public MyInterceptor(Object targetObject,Transaction transaction){
		this.targetObject = targetObject;
		this.transaction = transaction;
	}
	//使用反射的原理来执行对应方法
	//使用代理对象进行调用相关方法的时候都要经过此方法
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		this.transaction.openSession();
		method.invoke(this.targetObject, args);
		this.transaction.closeSession();
		return null;
	}

}
