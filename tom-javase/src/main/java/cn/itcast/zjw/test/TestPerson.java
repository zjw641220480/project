package cn.itcast.zjw.test;

public class TestPerson {
	public TestPerson(){
		System.out.println("TestPerson.TestPerson()");
	}
	static{
		System.out.println("静态代码块");
	}
	{
		System.out.println("构造代码块");
	}
}
