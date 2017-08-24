package cn.itcast.zjw.simple.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-provider.xml");
        context.start();
        System.out.println("提供者服务已注册成功");    
        System.out.println("请按任意键取消提供者服务"); 
        System.in.read(); // 按任意键退出
        System.out.println("Provider.main()");
    }
}
