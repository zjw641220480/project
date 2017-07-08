package cn.itcast.zjw.aop.xml;

/**
 * 
 * <p>Titile:Target</p>
 * <p>Description:目标类 </p>
 * @author TOM
 * @date 2017年7月8日 上午8:03:12
 */
public class Target {
	public void runTargetMethod(){
		System.out.println("Target.runTargetMethod()");
		System.out.println("目标类中的相关方法运行");
	}
}
