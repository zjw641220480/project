package cn.itcast.zjw.thread.conpro;
/**
 *
 * <p>Title:Resource.java</p>
 * <p>Description:资源</p>
 * @author TOM
 * @date 2017年4月11日下午6:41:09
 */
public class Resource {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Resource [name=" + name + ", age=" + age + "]";
	}
}
