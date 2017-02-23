package cn.itcast.zjw.enums;

/**
 *
 * <p>Title:SimpleEnum.java</p>
 * <p>Description:一个最简单的枚举类,枚举本身也是一个类</p>
 * @author TOM
 * @date 2017年2月23日上午10:19:37
 */
public enum SimpleEnum {
	//父类Enum中的很多方法都是final类型的,不能被子类所复写,
	//枚举实例的定义必须放置在开头,即使是变量的定义也不能放在它们的前面;
	MON, TUE, WED(1), THU(2), FRI(3), SAT(4), SUN(5);
	SimpleEnum() {//默认调用的就是无参的构造方法
		System.out.println(this.ordinal());
		System.out.println(this.name());
		System.out.println("SimpleEnum.SimpleEnum()");
	}
	SimpleEnum(int x) {//默认调用的就是无参的构造方法
		this.ordinal = x;
		System.out.println(this.ordinal());
		System.out.println(this.name());
		System.out.println("SimpleEnum.SimpleEnum()");
	}
	private int ordinal;
	
	public int getOrdinal() {
		return ordinal;
	}

}
