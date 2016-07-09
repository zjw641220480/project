package cn.itcast.zjw.object.keyword;


/** 
* @ClassName: Person_this 
* @Description:用于演示this关键字;
* this代表它所在函数所属对象的引用;简单说:哪个函数在调用this所在的函数,this就代表哪个对象;
* @author Tom
* @date 2016-2-27 
*/ 
public class Person_this {
	private int age;
	@SuppressWarnings("unused")
	private String name;
	
	public Person_this() {
		super();
	}
	public Person_this(String name){
		this.name = name;
	}
	public Person_this(int age) {
		this.age = age;
	}
	public Person_this(String name,int age){
		this(name);
		this.age = age;
	}
	/** 
	* @Title: compare 
	* @Description:用来演示this关键字的用法:
	* 该函数内部要用到    调用该函数的对象    的时候,用this来表示该对象;
	* @param p
	* @return 
	* @return boolean
	* @author Tom
	* @date 2016-2-27
	*/ 
	public boolean compare(Person_this p){
		return this.age==p.age;
	}
	
	public static void main(String[] args) {
		Person_this p1 = new Person_this(20);
		Person_this p2 = new Person_this(23);
		boolean b = p1.compare(p2);
		if(b){
			System.out.println("两个人年龄相同");
		}else{
			System.out.println("两个人年龄不同");
		}
	}
}
