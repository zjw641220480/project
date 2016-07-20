package cn.itcast.zjw.base.createobject;

public class HelloWorldFactory {
	/**
	 * 
	 * @Method:getInstance
	 * @Description:静态工厂创建对象
	 * @author TOM
	 * @date 2016年7月19日
	 * @return
	 */
	public static HelloWorld getInstanceStatic(){
		return new HelloWorld();
	}
	/**
	 * 
	 * @Method:getInstance
	 * @Description:实例化工厂创建对象;
	 * @author TOM
	 * @date 2016年7月19日
	 * @return
	 */
	public HelloWorld getInstance(){
		return new HelloWorld();
	}
}
