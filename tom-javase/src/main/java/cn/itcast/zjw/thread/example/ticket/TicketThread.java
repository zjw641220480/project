package cn.itcast.zjw.thread.example.ticket;

/**
 * 需求:简单的卖票程序 多个窗口同时买票
 * */
public class TicketThread {
	public static void main(String[] args) {
		Ticket ticketA = new Ticket("窗口一");
		Ticket ticketB = new Ticket("窗口二");
		Ticket ticketC = new Ticket("窗口三");
		Ticket ticketD = new Ticket("窗口四");
		ticketA.start();
		ticketB.start();
		ticketC.start();
		ticketD.start();
		/*
		 * ticketA.start(); ticketA.start(); ticketA.start();
		 */
	}
}

/**
 * @ClassName: Ticket
 * @Description: TODO
 * @author Tom
 * @date 2016-3-4
 */
class Ticket extends Thread {
	// 让4个窗口同时共享这100张票,共享这一个数据,把这个变量直接变为static
	// 如果不加static,那么会造成各个对象都拥有各自的100张票
	private static int tick = 100;

	public Ticket(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			//跟使用到的锁还是有一定关系的!!!!
			//静态资源用的锁不是对象,
			synchronized (Ticket.class) {
				if (tick > 0) {
					// 线程休息来模拟卖票出错的情况
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "卖出了\t" + tick--);
				}
			}
		}
	}
}
