package cn.itcast.zjw.enums;

public enum Season {
	//下面是这个枚举类中可以直接使用的实例化了的枚举对象;
	SPRING(1), SUMMER(2), FALL(3), WINTER(4);
	//枚举自身的私有的构造器,每一个类型实际就是一个实例化了的枚举对象
	private Season(int x){
		this.x=x;
		System.out.println(this.toString());
		System.out.println("Season.Season()");
		System.out.println("枚举中指明每一个枚举实例编号的构造器运行");
	}
	private int x;
	public int getX() {
		return x;
	}
}
