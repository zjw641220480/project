package cn.itcast.zjw.aop.proxy.cglibproxy;
/**
 * 
 * @ClassName:Transaction
 * @Description:这个类专门处理事务,相当于切面的作用
 * @Time:2016年8月16日
 * @author:Tom
 */
public class Transaction {
	/**
	 * 
	 * @MethodName:openSession
	 * @Description:打开事务
	 * @Time:2016年8月16日下午11:18:43
	 * @author:Tom
	 */
	public void openSession(){
		System.out.println("打开数据库连接");
		System.out.println("开启事务");
	}
	/**
	 * 
	 * @MethodName:closeSession
	 * @Description:提交并关闭事务
	 * @Time:2016年8月16日下午11:18:51
	 * @author:Tom
	 */
	public void closeSession(){
		System.out.println("提交事务");
		System.out.println("关闭事务");
		System.out.println("关闭数据库连接");
	}
}
