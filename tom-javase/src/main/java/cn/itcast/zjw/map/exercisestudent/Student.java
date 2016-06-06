package cn.itcast.zjw.map.exercisestudent;

public class Student implements Comparable<Student>{
	private String sname;
	private int age;
	public Student(){}
	public Student(String sname, int age) {
		super();
		this.sname = sname;
		this.age = age;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		System.out.println(this.sname+"\tStudent.hashCode()");
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println(this.sname+"\tStudent.equals()");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}
	public int compareTo(Student s) {
		int num = new Integer(this.age).compareTo(new Integer(s.getAge()));
		if(num == 0){
			return this.sname.compareTo(s.getSname());
		}
		return num;
	}
}
