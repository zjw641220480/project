package cn.itcast.zjw.object.ploymorphic;

/** 
* @ClassName: DuoTaiApply 
* @Description: 多态的应用实例,基础班,高级班;
* @author Tom
* @date 2016-2-29 
*/ 
public class DuoTaiApply {
	public static void main(String[] args) {
		BaseStudent baseStudent = new BaseStudent();
		AdvStudent advStudent = new AdvStudent();
	/*	baseStudent.study();
		baseStudent.sleep();*/
		function(baseStudent);
		function(advStudent);
		
	}
	public static void function(Student student){
		student.sleep();
		student.study();
	}
}
abstract class Student{
	public abstract void study();
	public void sleep(){
		System.out.println("student.sleep()");
	}
}

class BaseStudent extends Student{

	@Override
	public void study() {
		System.out.println("BaseStudent.study()");
	}

	@Override
	public void sleep() {
		System.out.println("BaseStudent.坐着睡");
	}
	
}
class AdvStudent extends Student{
	@Override
	public void study() {
		System.out.println("AdvStudent.study()");
	}
}