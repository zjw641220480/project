package cn.itcast.zjw.springbase.proxy.jdkproxy;

import org.junit.Test;

import cn.itcast.zjw.springbase.initelements.InitElementsPerson;

/** 
 * @ClassName:TargetObject
 * @Description:最原始的目标对象,后面需要进行增强
 * @author TOM
 * @date 2016年5月27日 下午1:28:43
 * @version V1.0.0
 */ 
public class JdkTargetObject implements ObjectInterface{
	@Test
	public InitElementsPerson show(String params){
		System.out.println("最原始的Jdk类型目标对象中的方法运行了");
		System.out.println("传递进来的输入参数为:\t"+params);
		InitElementsPerson initElementsPerson = new InitElementsPerson();
		initElementsPerson.setAge("11");
		initElementsPerson.setName("张三");
		return initElementsPerson;
	}
}
