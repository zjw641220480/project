package cn.itcast.zjw.springbase.initelements;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.itcast.zjw.springbase.createobject.SpringPerson;

public class InitElementsPerson {
	private int a;
	private String name;
	private String age;
	private SpringPerson springPerson;
	private List<Object> list;
	private Set<Object> set;
	private Map<Object,Object> map;
	
	//当有其他类型的构造函数时候,其默认构造函数也是需要添加的;
	public InitElementsPerson(){}
	public InitElementsPerson(int a, String name, String age, SpringPerson springPerson) {
		super();
		this.a = a;
		this.name = name;
		this.age = age;
		this.springPerson = springPerson;
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public SpringPerson getSpringPerson() {
		return springPerson;
	}
	public void setSpringPerson(SpringPerson springPerson) {
		this.springPerson = springPerson;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Set<Object> getSet() {
		return set;
	}
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	public Map<Object, Object> getMap() {
		return map;
	}
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "InitElementsPerson [a=" + a + ", name=" + name + ", age=" + age + ", springPerson=" + springPerson + ", list=" + list + ", set=" + set + ", map=" + map + "]";
	}
	
}
