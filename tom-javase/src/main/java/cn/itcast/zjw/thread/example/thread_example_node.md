# tom-javase-thread
java中的thread-->example;
	BankDemo:一个线程加锁的小案例,一些基础的内容,需要仔细体会下;使用的还是synchronized锁,
	TickerInterface:实现Runnable方式进行卖票;
	TicketThread:继承Thread方式来进行卖票;
	
	线程影响的只是run和call方法体中的内容;线程只是去运行这些代码块;
	
	多个线程操作同一份数据,并对数据有进行修改的时候,才会造成线程并发问题;
	
	锁是锁,逻辑是逻辑,两个无必然联系,逻辑是业务,锁是解约多线程并发,先把逻辑理清楚,该加锁的地方加锁;
	
	同一份数据的意思是,多个线程操作同一个成员变量(全局变量),或者类变量;
	

	
	
	
	