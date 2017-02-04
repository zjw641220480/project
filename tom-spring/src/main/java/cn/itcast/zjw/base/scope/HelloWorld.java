package cn.itcast.zjw.base.scope;

public class HelloWorld {
	public HelloWorld() {
		super();
		System.out.println(this.toString());
		System.out.println("HelloWorld.HelloWorld()");
		System.out.println("HelloWorld对象创建成功");
	}

	public void hello(){
		System.out.println(this.toString());
		System.out.println("HelloWorld.hello()");
	}
}
