package cn.itcast.zjw.domain.hibernate;

import java.io.Serializable;
/*
 * 对象序列化的作用是使得对象可以在网络上以二进制的形式传输;
 * Serializable标识接口,它的内容为空,把一个对象变为二进制;把这个对象变为了二进制流;
 * */
public class Person implements Serializable{
	/** @Fields serialVersionUID: */
	  	
	private static final long serialVersionUID = 1L;
	private long pid;
	private String pname;
	private String psex;
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex + "]";
	}
	
}
