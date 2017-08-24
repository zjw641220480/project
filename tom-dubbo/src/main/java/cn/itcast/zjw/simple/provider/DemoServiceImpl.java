package cn.itcast.zjw.simple.provider;

import cn.itcast.zjw.simple.service.DemoService;

public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "Hello " + name;
	}

}
