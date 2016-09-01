package cn.itcast.zjw.enums;
/**
 * 注意:
 * 	1:枚举中的构造方法只能是私有的
 *  2:
 * @ClassName:ColorEnum
 * @Description:
 * @Time:2016年9月1日
 * @author:Tom
 */
public enum ColorEnum {

	RED("red",1) {
		@Override
		public void method() {
			System.out.println("ColorEnum.RED中的方法方法运行");
		}
	},
	YELLOW("yellow",2) {
		@Override
		public void method() {
			System.out.println("ColorEnum.YELLOW中的方法运行");
		}
	},
	GREEN("green",3) {
		@Override
		public void method() {
			System.out.println("ColorEnum.GREEN中的方法运行");
		}
	},
	BLACK {
		@Override
		public void method() {
			System.out.println("ColorEnum.BLACK中的方法运行");
		}
	};
	
	/**
	 * 
	 * @MethodName:ColorEnum
	 * @Description:枚举类中有参数的构造方法
	 * @author:TOM
	 * @Time: 2016年9月1日
	 * @param name
	 * @param x
	 */
	private ColorEnum(String name,int x){
		this.x = x;
		this.name = name;
		System.out.println(this.toString());
		System.out.println("ColorEnum.ColorEnum()");
		System.out.println("枚举中有两个参数的构造器运行");
	}
	/**
	 * 
	 * @MethodName:ColorEnum
	 * @Description:枚举类中无参数的构造方法;
	 * @author:TOM
	 * @Time: 2016年9月1日
	 */
	private ColorEnum(){
		System.out.println(this.toString());
		System.out.println("ColorEnum.ColorEnum()");
		System.out.println("枚举中的无惨构造器运行");
	}
	//枚举类中的两个变量
	private int x;
	private String name;
	
	public int getX() {
		return x;
	}
	public String getName(){
		return name;
	}
	//当在一个枚举里面写了抽象方法之后,需要再每个实例上面都实现这个抽象方法,无论这个枚举对象是由哪种构造函数来创建的;
	public  abstract void method();

}
