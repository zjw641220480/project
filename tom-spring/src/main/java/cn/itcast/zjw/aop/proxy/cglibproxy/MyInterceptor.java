package cn.itcast.zjw.aop.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 
 * @ClassName:MyInterceptor
 * @Description:产生代理类的拦截器,
 * @Time:2016年8月17日
 * @author:Tom
 */
public class MyInterceptor implements MethodInterceptor{
	//引入目标类
	private Object target;
	//引入切面类
	private Transaction transaction;
	public MyInterceptor(Object target,Transaction transaction){
		this.target = target;
		this.transaction = transaction;
	}
	/**
	 * 
	 * @MethodName:createProxy
	 * @Description:用来产生代理对象,(Cglib方式采用的是继承的方式)
	 * @return
	 * @Time:2016年8月23日上午11:00:21
	 * @author:Tom
	 */
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);//this代表拦截器对象本身
		enhancer.setSuperclass(this.target.getClass());//设置代理类的父类为目标类
		enhancer.create();
		return target;
	}
	/**
	 * 该方法的内容,和jdkproxy中的invoke方法的内容是一样的;
	 */
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy)
			throws Throwable {
		this.transaction.openSession();
		method.invoke(this.target, objects);
		this.transaction.closeSession();
		return null;
	}
	
}
