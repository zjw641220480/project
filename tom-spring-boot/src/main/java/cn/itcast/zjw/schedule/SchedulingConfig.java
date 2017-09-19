package cn.itcast.zjw.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
 * @ClassName: SchedulingConfig
 * @Description: SpringBoot中定时器的使用，配置十分简单，一个类中可配置多个定时器
 * @author: TOM
 * @Time: 2017年9月19日
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	@Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }
	@Scheduled(cron = "0/10 * * * * ?") // 每10秒执行一次
	public void schedulerB() {
		System.out.println("SchedulingConfig.schedulerB()==============10s");
	}
}
