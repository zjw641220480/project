package cn.itcast.zjw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 
 * @ClassName: RedisSessionConfig.java
 * @Description:使用Redis缓存在管理Session,使用nginx或者apache，都无须在关心多个app之间的session一致的问题了;
 * @Time 2017年9月20日
 * @author: Tom
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 3600)
public class RedisSessionConfig {
	
}
