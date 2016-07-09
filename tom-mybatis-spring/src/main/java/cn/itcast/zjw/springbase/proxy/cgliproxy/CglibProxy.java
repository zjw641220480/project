package cn.itcast.zjw.springbase.proxy.cgliproxy;


import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	// CGLIB目标对象
	CglibTargetObject cglibTargetObject = null;
	public Object initCglibTargetObject(CglibTargetObject cglibTargetObject){
		this.cglibTargetObject = cglibTargetObject;
		Enhancer enhancer = new Enhancer();//该类是cglib专门用于生成代理对象所需要使用的;
		enhancer.setSuperclass(this.cglibTargetObject.getClass());//设置目标类的父类;
		enhancer.setCallback(this);
		return enhancer.create();
	}
	/**
	 * @MethodName:intercept
	 * @Desription:
	 * @param proxy 目标对象的代理对象
	 * @param method 对应于在代理实例上调用接口方法的Method实例
	 * @param args 传入到代理实例上方法参数值的对象数组
	 * @param methodProxy
	 * @return 方法的返回值,没有返回值的时候为null
	 * @throws Throwable
	 * @date:2016年5月27日
	 * @author TOM
	 * @see org.springframework.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.springframework.cglib.proxy.MethodProxy) 
	 */ 
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		System.out.println("代理的目标类实例\t"+proxy.getClass());
		System.out.println("方法名称\t"+method.getName());
		if(args!=null&&args.length>0){//目标方法的参数值
			for(Object obj:args){
				System.out.println("方法参数值\t"+obj);
			}
		}
		//定义方法的返回值,没有返回值的时候为null
		Object returnObject = null;
		//使用反射,调用目标对象的方法
		//returnObject = method.invoke(this.cglibTargetObject, args);
		returnObject = methodProxy.invoke(this.cglibTargetObject, args);
		return returnObject;
	}
	
}
