package cn.itcast.zjw.base.domain;

import org.springframework.stereotype.Component;

@Component
public class Student{
	public void say(){
		System.out.println(this.toString());
		System.out.println("Student.say()");
	}
}
