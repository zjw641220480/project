package cn.itcast.zjw.enums;

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(ColorEnum.GREEN.getX());
		ColorEnum.GREEN.method();
		System.out.println(ColorEnum.RED);
		System.out.println(ColorEnum.RED.getName());
		ColorEnum colorEunm = ColorEnum.GREEN;
		switch (colorEunm) {
		case GREEN:
			System.out.println("GREEN");
			break;
		default:
			break;
		}
	}
}
enum ColorEnum{
	RED("red",1) {
		@Override
		public void method() {
			System.out.println("ColorEnum.RED");
		}
	},
	YELLOW("yellow",2) {
		@Override
		public void method() {
			System.out.println("ColorEnum.YELLOW");
		}
	},
	GREEN("green",3) {
		@Override
		public void method() {
			System.out.println("ColorEnum.GREEN");
		}
	};
	private final int x;
	private String name;
	//枚举中的构造方法只能是私有的
	private ColorEnum(String name,int x){
		this.x = x;
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public String getName(){
		return name;
	}
	//当在一个枚举里面写了抽象方法之后,需要再每个实例上面都实现这个抽象方法
	public  abstract void method();
}