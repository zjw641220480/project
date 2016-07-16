package cn.itcast.zjw.domain;

/**
 * @ClassName:Student
 * @Description:用来给TreeSet集合使用的javaBean,注意,元素自身的比较(是否为同一对象)这种行为是对象自身的事情
 * @author TOM
 * @date 2016年5月27日 下午12:58:46
 * @version V1.0.0
 */
public class Student implements Comparable<Object> {// 改接口强制让学生具备比较性
	private String sex;
	private String name;
	private int age;

	public Student(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public Student() {

	}

	public Student(String name, int age, String sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	/*
	 * 排序的时候所需要使用到的方法
	 */
	// 年龄一致便需要进行次要元素验证,
	// 次要元素认证为对姓名的判断
	public int compareTo(Object obj) {
		if (!(obj instanceof Student)) {
			throw new RuntimeException("不是学生对象");
		}
		Student stu = (Student) obj;
		System.out.println(this.age + "-----compareto-----" + stu.getAge());
		if (this.age > stu.age) {
			return 1;
		} else if(this.age==stu.age){
		//对次要条件的判断
			return this.name.compareTo(stu.getName());
		}
		return -1;
	}
	/*认为只要是年龄一致就是同一个元素,就不会把第二个元素放入进来;
	public int compareTo(Object obj) {
		if (!(obj instanceof Student)) {
			throw new RuntimeException("不是学生对象");
		}
		Student stu = (Student) obj;
		System.out.println(this.age + "-----compareto-----" + stu.getAge());
		if (this.age > stu.age) {
			return 1;
		} else if (this.age == stu.age) {
			return 0;
		} else {
			return -1;
		}
		// else if(this.age==stu.age){
		// //对次要条件的判断
		// return this.name.compareTo(stu.getName());
		// }
		// return -1;
	}
	*/
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
