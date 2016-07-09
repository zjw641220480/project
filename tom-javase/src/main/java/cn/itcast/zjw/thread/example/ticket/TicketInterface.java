package cn.itcast.zjw.thread.example.ticket;

/** 
* @ClassName: TicketInterface 
* @Description: 实现Runnable接口的方式来卖票
* 多线程的运行出现了安全问题是最需要注意的一点,
* 	问题的原因:
* 		当多条语句在操作同一个线程的共享数据时候,一个线程对多条语句只执行了一部分,还没有执行完,另一个线程参与进来执行
* 	导致了共享数据的错误,
* 	解决办法,对多条操作共享数据的语句,只能让一个线程都执行完,在执行的过程中,其他线程不可以参与进来,java对于多线程的安全问题提供了专业的解决方式,
* 就是同步代码块----synchronized
* synchronized(对象){
* 	需要被同步的代码
* }
* 对象如同锁,持有锁的线程可以在同步中执行,没有持有锁的线程即使获取了cpu的执行权,也进不去,因为没有获取锁,
* 火车上的卫生间----经典;
* 同步的前提,
* 	必须要有两个或者两个以上的线程
* 	必须是多个线程使用同一个锁,
* 	必须保证同步中只能有一个线程在运行,
* 好处:解决了多线程的安全问题,
* 弊端:对锁进行判断,较为消耗资源
* @author Tom
* @date 2016-3-4 
*/ 
public class TicketInterface {
	public static void main(String[] args) {
		TicketInter ticketInter = new TicketInter();
		Thread threadA = new Thread(ticketInter);
		Thread threadB = new Thread(ticketInter);
		Thread threadC = new Thread(ticketInter);
		Thread threadD = new Thread(ticketInter);
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
	}
}
class TicketInter implements Runnable{
		//实现的方式并不需要吧变量放入到static中
		private int tick = 100;
		public void run() {
			while(true){
				synchronized(TicketInter.class){
					if(tick>0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"\tticked:\t"+tick--);
					}
				}
			}
		}
}
