package cn.itcast.zjw.design.prototype;

import java.util.ArrayList;
import java.util.List;

public class PersonPrototype implements Cloneable{
	//基本数据类型
    private int age;
    //String引用类型,这个是和基本数据类型的结果一致的
    private String name;
  //引用类型
    private List<String> friends=new ArrayList<String>();
    //对象
    private School school;
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
}
