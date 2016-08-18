package cn.itcast.zjw.aop.proxy.jdkproxy.jdksalary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInterceptor implements InvocationHandler{
	private Object target;
	private Logger logger;
	private Privilege privilege;
	private Security security;
	
	public MyInterceptor(Object target, Logger logger, Privilege privilege, Security security) {
		super();
		this.target = target;
		this.logger = logger;
		this.privilege = privilege;
		this.security = security;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//启动日志
		logger.logging();
		//启动安全框架
		security.security();
		//权限校验
		if(this.privilege.getAccress().equals("admin")){
			System.out.println("拥有相应的权限可以查看工资");
			method.invoke(target, args);//调用方法
		}else{
			System.out.println("没有权查看");
		}
		
		return null;
	}

}
