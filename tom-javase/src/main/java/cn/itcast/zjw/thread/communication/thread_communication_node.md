# tom-javase-thread
java中的thread-->communcation;
	CommuncicationLock:使用Lock加锁方式来对同一份资源进行读写,(有点复杂了)
	Communication:使用synchronized原始方式对同一份资源进行读写
	CommunicationLockTow:在资源内部直接实现对资源的读写,
	OptimizeCommunication:优化了的针对统一资源线程并发时候等待唤醒机制的案例
	ProduceAndConsumerSynchronized:
	ProduceAndConsumLock:使用Lock和Condition来实现生产者和消费者案例
	
在使用1.5新特性中的Lock时候
	Lock用来加锁和解锁,
	Condition用来将特定线程唤醒或休眠,  试着把Condition理解为子锁,多种类型的锁,多种锁之间用boolean等类型值进行区分;
	Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。 
	