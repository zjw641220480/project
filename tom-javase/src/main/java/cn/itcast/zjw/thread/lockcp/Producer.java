package cn.itcast.zjw.thread.lockcp;

/**
 * 
 * <p>
 * Titile:Producer
 * </p>
 * <p>
 * Description: 生产者
 * </p>
 * 
 * @author TOM
 * @date 2017年7月30日 下午3:45:38
 */
public class Producer {
	private Depot depot;

	public Producer(Depot depot) {
		this.depot = depot;
	}

	// 生产产品：新建一个线程向仓库中生产产品。
	public void produce(final int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}
