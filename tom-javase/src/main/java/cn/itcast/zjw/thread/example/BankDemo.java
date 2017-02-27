package cn.itcast.zjw.thread.example;
/**
 * 需求:
 * 	银行有一个金库,
 * 	有两个储户分别存300,每次存100,寸3次
 * 	目的:该程序是否有安全问题,如果有,该如何解决
 * 如何找到问题,
 * 	明确哪些代码是多线程运行代码
 * 	明确共享数据
 * 	明确多线程运行代码中哪些语句是操作共享数据的
 * */
public class BankDemo {
	public static void main(String[] args) {
		Cus cus = new Cus();
		Thread threadA = new Thread(cus);
		Thread threadB = new Thread(cus);
		threadA.start();
		threadB.start();
	}
}
/**
 * 
 * @ClassName:Bank
 * @Description:
 * @Time:2017年2月24日
 * @author:Tom
 */
class Bank{
	//因为bank对象只有一个,然后sum同样定义在成员变量位置,导致多个线程操作同一个bank对象的同一个sum数据--同一份数据(成员变量)
	private int sum;
	//和sum的性质一致,所以才可以在这里这样来定义一个Object类型的锁;
	Object obj = new Object();
	public void add(int n){
		synchronized(obj){
			System.out.println(obj);
			sum = sum +n;
			System.out.println("sum\t"+sum);
		}
	}
}
/**
 * 
 * @ClassName:Cus
 * @Description:针对客户而言
 * @Time:2017年2月24日
 * @author:Tom
 */
class Cus implements Runnable{
	//Bank定义在成员变量上,Cus类初始化一次,形成一个bank对象,main方法中两个线程操作的是这同一个bank对象;
	private Bank bank = new Bank();
	public void run() {
		//当Bank定义在局部变量的时候,两个线程,各自操作自己的bank对象,各自操作自己的sum,不存在并发问题
		//Bank bank = new Bank();
		for(int x=0;x<3;x++){
			System.out.println(bank);
			System.out.println(Thread.currentThread().getName());
			bank.add(100);
		}
	}
}
