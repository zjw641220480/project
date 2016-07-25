package cn.itcast.zjw.base.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
	private Long pid;
	private String name;
	private Student student;
	private List stringList;
	private Set studentsSet;
	private Map studentsMap;
	private Object[] objects;
	private Properties properties;
	//使用构造函数对属性赋值时候使用的构造器
	public Person(String name,Student student){
		this.name = name;
		this.student = student;
	}
	public Person(){
		System.out.println("Person.Person()\t默认构造函数");
	}
	public void init(){
		System.out.println(this.toString());
		System.out.println("Person.init()");
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List getStringList() {
		return stringList;
	}
	public void setStringList(List stringList) {
		this.stringList = stringList;
	}
	public Set getStudentsSet() {
		return studentsSet;
	}
	public void setStudentsSet(Set studentsSet) {
		this.studentsSet = studentsSet;
	}
	public Map getStudentsMap() {
		return studentsMap;
	}
	public void setStudentsMap(Map studentsMap) {
		this.studentsMap = studentsMap;
	}
	public Object[] getObjects() {
		return objects;
	}
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
