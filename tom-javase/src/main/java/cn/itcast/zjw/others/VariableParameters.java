package cn.itcast.zjw.others;
/**
 * 1:当存在无参的重载方法,而又在其他方法中调用到了无参方法,那么默认调用的就是无参方法,只带有可变参数的方法优先级相对较低
 * 2:当存在两个都是只有可变参数的方法,却又不存在无参的方法时候,调用无参方法,编辑器直接报错;
 * @ClassName:VariableParameters
 * @Description:用来演示一个类中方法重载时候,可变参数对重载的影响
 * @Time:2016年9月1日
 * @author:Tom
 */
public class VariableParameters {
	public void show(){
		System.out.println("VariableParameters.show()\t无参数");
	}
	public void show(String... strings ){
		System.out.println("VariableParameters.show()\tString可变参数");
	}
	public void show(Integer... integers){
		System.out.println("VariableParameters.show()\tInteger可变参数");
	}
	/**
	 * 
	 * @MethodName:main
	 * @Description:当没有无参方法的时候,直接报错;当有无参方法的时候默认调用的是无参方法;
	 * @param args
	 * @Time:2016年9月1日上午9:43:43
	 * @author:Tom
	 */
	public static void main(String[] args) {
		VariableParameters variableParameters = new VariableParameters();
		variableParameters.show();
	}
}
