package cn.itcast.zjw.object;

/** 
* @ClassName: PersonRAM 
* @Description: 用来演示类创建对象过程中,在内存中分配情况;
* @author Tom
* @date 2016-2-27 
*/ 
public class PersonRAM {
	private String name;
	private int age;
	private static String country = "CN";
	//静态代码快
	static{
		System.out.println("static静态代码快执行\t"+country);
	}
	//构造代码快
	{
		System.out.println("构造代码快执行");
		/*
		 * 构造代码快执行,而构造函数还没有执行的时候,默认初始化成员变量;
		 * 还没有进行显示初始化成员变量;
		 * name=null	age=0;
		 * */
		System.out.println(name+",,,,"+age);
		
	}
	
	public PersonRAM(String name,int age){
		this.age=age;
		this.name=name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void speak(){
		System.out.println("PersonRAM.speak()\t"+"姓名是:"+name);
	}
	public static void showCountry(){
		System.out.println("国家是:"+country);
	}
	public static void main(String[] args) {
		/*
		 * 该句话都做了什么事情;
		 * 		1,因为new用到了PersonRAM.class,所以会先找到PersonRAM.class文件并加载到内存中,
		 * 		2,执行该类中的static代码块,如果有的话,给PersonRAM.class类进行初始化;
		 * 		3,在堆内存中开辟空间,分配内存地址,
		 * 		4,在堆内存中建立对象的特有属性,并进行默认初始化
		 * 		5,对属性进行显示初始化,
		 * 		6,对对象进行构造代码快初始化,
		 * 		7,对对象进行对应的构造函数初始化;
		 * 		8,将内存地址赋值给栈内存中的personRAM变量;
		 * */
		PersonRAM personRAMa = new PersonRAM("李四", 20);
		personRAMa.setName("张三");
		personRAMa.speak();
		System.out.println("**************重新创建PersonRAM实例***************");
		PersonRAM personRAMb = new PersonRAM("李四", 20);
		personRAMb.speak();
	}
}
