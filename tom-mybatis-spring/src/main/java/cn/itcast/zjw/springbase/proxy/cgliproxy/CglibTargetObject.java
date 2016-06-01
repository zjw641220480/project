package cn.itcast.zjw.springbase.proxy.cgliproxy;

import cn.itcast.zjw.springbase.initelements.InitElementsPerson;

public class CglibTargetObject {
	public InitElementsPerson show(String param){
		System.out.println("传递过来的参数为:\t"+param);
		System.out.println("CGLIB类型的目标对象运行");
		InitElementsPerson initElementsPerson = new InitElementsPerson();
		initElementsPerson.setName("CGLIB");
		return initElementsPerson;
	}
}
