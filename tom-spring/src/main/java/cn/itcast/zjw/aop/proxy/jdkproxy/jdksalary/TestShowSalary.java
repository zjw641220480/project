package cn.itcast.zjw.aop.proxy.jdkproxy.jdksalary;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestShowSalary {
	@Test
	public void testShowSalary(){
		//目标对象
		SalaryManager salaryManager = new SalaryManagerImpl();
		//切面
		Logger logger = new  Logger();
		Security security = new Security();
		Privilege privilege = new Privilege();
		privilege.setAccress("admin");
		//产生代理对象的拦截器
		MyInterceptor interceptor = new  MyInterceptor(salaryManager, logger, privilege, security);
		//使用连接器产生代理对象
		salaryManager = (SalaryManager) Proxy.newProxyInstance(salaryManager.getClass().getClassLoader(), salaryManager.getClass().getInterfaces(), interceptor);
		salaryManager.showSalary();
	}
}	
