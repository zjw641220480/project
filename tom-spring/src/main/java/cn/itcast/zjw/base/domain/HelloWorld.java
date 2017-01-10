package cn.itcast.zjw.base.domain;

/**
 * 
 * @ClassName:HelloWorld
 * @Description:
 * @author Tom
 * @Time:2016年7月24日
 *
 */
public class HelloWorld {
	/**
	 * 构造方法
	 */
	public HelloWorld() {
		super();
		System.out.println(this.toString());
		System.out.println("HelloWorld.HelloWorld()");
		System.out.println("HelloWorld对象创建成功");
	}

	/**
	 * 
	 * @Method:hello
	 * @Description:
	 * @author Tom
	 * @date 2016年7月24日 上午9:48:46
	 */
	public void hello() {
		System.out.println(this.toString());
		System.out.println("HelloWorld.hello()");
	}
	/**
	 * 
	 * @Method:init
	 * @Description:容器的初始化方法
	 * @author Tom
	 * @date 2016年7月24日 上午10:01:10
	 */
	public void init(){
		System.out.println(this.toString());
		System.out.println("HelloWorld.init()");
	}
	/**
	 * 
	 * @Method:destory
	 * @Description:容器的销毁方法
	 * @author Tom
	 * @date 2016年7月24日 上午10:01:28
	 */
	public void destroy(){
		System.out.println(this.toString());
		System.out.println("HelloWorld.destroy()");
	}
}
