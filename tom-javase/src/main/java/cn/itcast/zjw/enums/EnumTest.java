package cn.itcast.zjw.enums;
/**
 * 
 * @ClassName:EnumTest
 * @Description:主要是对枚举在switch中的应用;
 * @author TOM
 * @Time: 2016年7月16日下午5:24:37
 */
public class EnumTest {
	private static ColorEnum colorEunm;
	public static void main(String[] args) {
		System.out.println("获得的GREEN颜色的编号:\t"+ColorEnum.GREEN.getX());
		ColorEnum.GREEN.method();
		System.out.println(ColorEnum.BLACK);
		colorEunm = ColorEnum.RED;
		// 枚举类中的编号作为switch的选择条件
		switch(colorEunm.getX()){
			case 1:
				System.out.println("编号为1的RED被选中");
				break;
			default:
				System.out.println("编号不是1的被选中");
		}
		//switch中应用枚举的时候,其选择的对象应该是枚举类本身对象,switch的是枚举对象本身
		colorEunm = ColorEnum.BLACK;
		switch (colorEunm) {
		case GREEN:
			System.out.println("GREEN被选中");
			break;
		case RED:
			System.out.println("RED被选中");
			break;
		case BLACK:
			System.out.println("BLACK被选中");
			break;
		default:
			break;
		}
	}
}
/**
 * 
 * @ClassName:ColorEnum
 * @Description:一个标准的枚举类
 * @author TOM
 * @Time: 2016年7月16日下午5:08:15
 */
enum ColorEnum{
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
	//枚举中的构造方法只能是私有的
	private ColorEnum(String name,int x){
		this.x = x;
		this.name = name;
		System.out.println(this.toString());
		System.out.println("ColorEnum.ColorEnum()");
		System.out.println("枚举中有两个参数的构造器运行");
	}
	private ColorEnum(){
		System.out.println(this.toString());
		System.out.println("ColorEnum.ColorEnum()");
		System.out.println("枚举中的无惨构造器运行");
	}
	private int x;
	private String name;
	
	public int getX() {
		return x;
	}
	public String getName(){
		return name;
	}
	//当在一个枚举里面写了抽象方法之后,需要再每个实例上面都实现这个抽象方法
	public  abstract void method();
}