package cn.itcast.zjw.enums;
/**
 * 
 * @ClassName:SwitchSeason
 * @Description:用于演示Season枚举类;
 * @Time:2016年9月1日
 * @author:Tom
 */
public class SwitchSeason {
	private Season season;

	public SwitchSeason(Season season) {
		this.season = season;
	}
	/**
	 * 
	 * @MethodName:displaySeason
	 * @Description:switch选择的是枚举类中的全局变量;
	 * @Time:2016年9月1日上午10:05:44
	 * @author:Tom
	 */
	public void displaySeason() {
		//switch中选择的就是枚举类中每一个枚举实例的编号
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
		// 当枚举类中只要有一个被外界所实例化,那么枚举类中的其他对象也会被实例化,他们都默认是static级别的
		SwitchSeason spring = new SwitchSeason(Season.SPRING);
		spring.displaySeason(); 
	}
}
