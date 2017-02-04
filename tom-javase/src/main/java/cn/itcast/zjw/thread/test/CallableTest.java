package cn.itcast.zjw.thread.test;

import java.util.concurrent.Callable;

public class CallableTest {
	public static void main(String[] args) {
		
	}
}

class CallableRespurce{
	String name;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}