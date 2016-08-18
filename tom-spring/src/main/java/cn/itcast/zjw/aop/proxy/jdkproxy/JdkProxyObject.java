package cn.itcast.zjw.aop.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 
 * @ClassName:JdkProxy
 * @Description:代理类,同样需要实现目标类所实现的接口
 * @Time:2016年8月16日
 * @author:Tom
 */
public class JdkProxyObject implements InvocationHandler{
	//JDK动态代理所代理的目标对象,在初始化代理类的时候,就会把目标类对象同样初始化;
	private Object targetObject = null;
	public JdkProxyObject(Object targetObject){
		this.targetObject = targetObject;
	}
	/** 
	 * @MethodName:createProxyInstance
	 * @Desription:初始化目标对象,主要是给目标对象赋值的;
	 * @date:2016年5月27日
	 * @author TOM
	 * @param targetObject 输入参数为所需要增强的目标对象
	 * @return  
	 */
	public Object createProxyInstance(JdkTargetObject targetObject){
		this.targetObject = targetObject;
		/*
		 * 第一个参数设置的是目标对象使用的类加载器,一般采用跟目标类相同的类加载器;
		 * 第二个参数设置的是目标对象所实现的所有接口,然后代理对象也会实现跟目标对象一致的接口;
		 * 第三个参数设置的是回调对象,当代理对象中的方法被调用之后,会调用该参数指定对象的invoke方法;
		 * */
		// 这个并不是必须的,还是用来取得目标对象,(使用的是同一个类加载器)
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
		//return null;
	}

	/**
	 * @MethodName:invoke
	 * @Desription:
	 * @param proxy 目标对象的代理对象
	 * @param method 对应于在代理实例上调用接口方法的Method实例
	 * @param args 传入到代理实例上方法参数值的对象数组
	 * @return 方法的返回值,没有返回值的时候为null
	 * @throws Throwable
	 * @date:2016年5月27日
	 * @author TOM
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) 
	 */ 
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理的目标类实例:\t"+proxy.getClass());
		System.out.println("方法名称:\t"+method.getName());
		if(args!=null&&args.length>0){//目标方法的参数值
			for(Object obj:args){
				System.out.println("方法参数值\t"+obj);
			}
		}
		//定义方法的返回值,没有返回值的时候为null
		Object returnObject = null;
		//   使用反射,调用目标对象的方法
		returnObject = method.invoke(this.targetObject, args);
		System.out.println("方法的返回值为\t"+returnObject);
		return returnObject;
	}
}
