package cn.itcast.zjw.object;

/**
 * @ClassName: MainDemo
 * @Description:用于演示主函数的解析 主函数的定义: 
 * Public:代表该函数的访问权限是最大的;
 * Static:代表主函数随着类的加载就存在了; Void:主函数没有具体的返回值;
 * Main:不是关键字,但是是一个特殊的单词,可以被jvm识别 
 * (String[] args):函数的参数,参数类型是一个数组,该数组中的元素是字符串;
 * 
 * Jvm在调用主函数的时候,传入的是new String[0];
 * @author Tom
 * @date 2016-2-27
 */
public class MainExplainDemo {
	public static void main(String[] args) {
		System.out.println(args);// [Ljava.lang.String;@5d888759
		System.out.println(args.length);// 0
	}
}
