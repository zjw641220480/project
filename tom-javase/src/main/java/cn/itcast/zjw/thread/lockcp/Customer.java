package cn.itcast.zjw.thread.lockcp;

/**
 * 
 * <p>Titile:Customer</p>
 * <p>Description:消费者 </p>
 * @author TOM
 * @date 2017年7月30日 下午3:46:18
 */
public class Customer {
	private Depot depot;

	public Customer(Depot depot) {
		this.depot = depot;
	}

	// 消费产品：新建一个线程从仓库中消费产品。
	public void consume(final int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}
}
