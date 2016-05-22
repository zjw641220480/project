package cn.itcast.zjw.domain;

public class Student implements Comparable<Object>{//改接口强制让学生具备比较性
	private String name;
	private int age;
	public Student(String name, int age) {
		this.age=age;
		this.name=name;
	}
	public Student(){
		
	}
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
	/* 排序的时候所需要使用到的方法
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		if(!(obj instanceof Student)){
			throw new RuntimeException("不是学生对象");
		}
		Student stu = (Student) obj;
		System.out.println(this.age+"-----compareto-----"+stu.getAge());
		if(this.age>stu.age){
			return 1;
		}else if(this.age==stu.age){
			//对次要条件的判断
			return this.name.compareTo(stu.getName());
		}
		return -1;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
