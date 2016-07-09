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
class Bank{
	private int sum;
	Object obj = new Object();
	public void add(int n){
		synchronized(obj){
			sum = sum +n;
			System.out.println("sum\t"+sum);
		}
	}
}

class Cus implements Runnable{
	private Bank bank = new Bank();
	public void run() {
		for(int x=0;x<3;x++){
			System.out.println(Thread.currentThread().getName());
			bank.add(100);
		}
	}
}
