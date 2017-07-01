# top-hadoop
	主要是对并发库中多种锁的相关理解;
	BlockingQueueTest:多个线程对一个BlockingQueue队列进行写入和读取,从而引出了读写锁的概念;
	CacheData:缓存的一个小案例,缓存很好理解,(借助map)但是里面当读锁里面有写锁的时候,需要写两层读锁,这个需要注意
	CountDownLatchTest:
	CyclicBarrierTest:一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
	可以理解成春游有多个目的地,全员到一个目的之后,稍作停留,再一起去下一个目的地;每个目的地就是一个公共的屏障点;
	ExchangerTest:两个线程之间数据的交换
	
	ReadWriteLockTest:空文件
	最主要的就是:BlockingQueueTest,CacheData