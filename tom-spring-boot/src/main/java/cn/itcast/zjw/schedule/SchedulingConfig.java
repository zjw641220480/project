package cn.itcast.zjw.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

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
