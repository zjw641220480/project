package cn.itcast.zjw.enums;

public enum Season {
	SPRING(1), SUMMER(2), FALL(3), WINTER(4);
	private int x;
	private Season(int x){
		this.x=x;
	}
	public int getX() {
		return x;
	}
}
