package cn.itcast.zjw.domain;
/**
 * 
 * @ClassName:Person
 * @Description:线程安全方式的ThreadLocal其相当于一个Map,线程的名称作为key,里面存放的是Person对象
 * @Time:2016年9月5日
 * @author:Tom
 */
public class Person {
	private static ThreadLocal<Person> map = new ThreadLocal<Person>();
	//哪个线程调用此方法,就获得此线程中存放的Person对象,在get方法中会有获取Thread的相关方法
	public static Person getInstance(){
		Person person = map.get();
		if(person==null){
			person = new Person();
			map.set(person);
		}
		return person;
	}
	public void clear(){
		map.remove();
	}
	private String pname;
	private String age;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
