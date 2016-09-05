package cn.itcast.zjw.trandition;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @ClassName:TraditionalTimerTest
 * @Description:传统定时器的演示
 * @Time:2016年9月1日
 * @author:Tom
 */
public class TraditionalTimerTest {
	public static void main(String[] args) {
		class myTimerTask extends TimerTask{
			
			@Override
			public void run() {
				System.out.println("bombing...");
				new Timer().schedule(new myTimerTask(), 3000);
			}
			//第一次炸的时间,后面每多长时间炸
		}
		new Timer().schedule(new myTimerTask(), 1000);
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
