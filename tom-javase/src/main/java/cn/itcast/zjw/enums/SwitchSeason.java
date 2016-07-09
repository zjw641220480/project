package cn.itcast.zjw.enums;

public class SwitchSeason {
	private Season season;

	public SwitchSeason(Season season) {
		this.season = season;
	}

	public void displaySeason() {
		switch (season.getX()) {
		case 1:
			System.out.println("春天花会开");
			break;
		case 2:
			System.out.println("炎热的夏天");
			break;
		case 3:
			System.out.println("秋天扫落叶");
			break;
		case 4:
			System.out.println("寒冷的冬天");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		// values方法列举枚举常量，ordinal方法为枚举常量的声明顺序
		SwitchSeason spring = new SwitchSeason(Season.SPRING);
		spring.displaySeason(); 
	}
}
