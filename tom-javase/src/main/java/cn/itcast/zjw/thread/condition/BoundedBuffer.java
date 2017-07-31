package cn.itcast.zjw.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <p>Titile:BoundedBuffer</p>
 * <p>Description:对并发包中Condition的使用说明 </p>
 * @author TOM
 * @date 2017年7月30日 下午4:58:43
 */
public class BoundedBuffer {
	final Lock lock = new ReentrantLock(false);
    final Condition putCondition  = lock.newCondition(); 
    final Condition takeCondition = lock.newCondition(); 

    final Object[] items = new Object[5];
    int putptr, takeptr, count;
    /**
     * 
     * @MethodName:put
     * @Description:向缓存中存入数据,当缓存满了的时候,等待
     * @param x
     * @throws InterruptedException
     * @Time: 2017年7月30日 下午4:59:03
     * @author: TOM
     */
    public void put(Object x) throws InterruptedException {
        lock.lock();    //获取锁
        try {
            // 如果“缓冲已满”，则等待；直到“缓冲”不是满的，才将x添加到缓冲中。
            while (count == items.length){
            	System.out.println("当前运行的线程是"+Thread.currentThread().getName()+"缓存已经满了:\t"+count);
            	// 释放锁,停止了当前生产的线程,并不是说所有的生产者只能等到消费者将消息消费完了才能再运行,
            	// 如果说这里使用的是Synchronized,那么当获取锁的线程还是生产者的时候,这个线程又重新释放锁;
            	putCondition.await();
            }
            	
            // 将x添加到缓冲中
            items[putptr] = x; 
            // 将“put统计数putptr+1”；如果“缓冲已满”，则设putptr为0。
            if (++putptr == items.length) putptr = 0;
            // 将“缓冲”数量+1
            ++count;
            // 唤醒take线程，因为take线程通过notEmpty.await()等待
            takeCondition.signal();

            // 打印写入的数据
            System.out.println(Thread.currentThread().getName() + " put  "+ (Integer)x);
        } finally {
            lock.unlock();    // 释放锁
        }
    }
    /**
     * 
     * @MethodName:take
     * @Description:从缓存拿取数据,当缓存已经空了的时候,等待;
     * @return
     * @throws InterruptedException
     * @Time: 2017年7月30日 下午4:59:35
     * @author: TOM
     */
    public Object take() throws InterruptedException {
        lock.lock();    //获取锁
        try {
            // 如果“缓冲为空”，则等待；直到“缓冲”不为空，才将x从缓冲中取出。
            while (count == 0) {
            	System.out.println("当前运行的线程是"+Thread.currentThread().getName()+"缓存已经空了:\t"+count);
            	// 释放锁,停止了当前消费的线程,并不是说所有的消费者只能等到消费者将消息消费完了才能再运行,
            	// 如果说这里使用的是Synchronized,那么当获取锁的线程还是消费者的时候,这个线程又重新释放锁;
            	takeCondition.await();
            }
            // 将x从缓冲中取出
            Object x = items[takeptr]; 
            // 将“take统计数takeptr+1”；如果“缓冲为空”，则设takeptr为0。
            if (++takeptr == items.length) takeptr = 0;
            // 将“缓冲”数量-1
            --count;
            // 唤醒put线程，因为put线程通过notFull.await()等待
            putCondition.signal();

            // 打印取出的数据
            System.out.println(Thread.currentThread().getName() + " take "+ (Integer)x);
            return x;
        } finally {
            lock.unlock();    // 释放锁
        }
    }
}
