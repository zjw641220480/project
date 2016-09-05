package cn.itcast.zjw.domain;
/**
 * 
 * @ClassName:Person
 * @Description:
 * @Time:2016年9月5日
 * @author:Tom
 */
public class Person {
	private static ThreadLocal<Person> map = new ThreadLocal<Person>();
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
