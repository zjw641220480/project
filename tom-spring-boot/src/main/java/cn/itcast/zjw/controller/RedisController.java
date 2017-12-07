package cn.itcast.zjw.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.util.RedisUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@RestController
@RequestMapping("/redis")
public class RedisController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RedisUtils redisUtils;
	
	@RequestMapping("/get")
    public String get2() {
    	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7000));
        // 使用redis集群中的任一节点即可
        JedisCluster jedis = new JedisCluster(jedisClusterNodes);
        jedis.set("111", "222");
        /*// 开始前，先移除所有的内容
        jedis.del("java framework");
        logger.info(jedis.lrange("java framework", 0, -1).toString());
        // 先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        logger.info(jedis.lrange("java framework", 0, -1).toString());
        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        logger.info(jedis.lrange("java framework", 0, -1).toString());*/
        String value = jedis.get("111");
        try {
			jedis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return value;
    }
	/**
	 * 
	 * @Method:getByUtil
	 * @Description:
	 * @Time 2017年12月8日 上午9:38:23
	 * @author: Tom
	 * @return 
	 */
	@RequestMapping("/getByUtil")
	public Object getByUtil() {
		System.out.println("RedisController.getByUtil()");
		redisUtils.set("getByUtil", "value");
		return redisUtils.get("getByUtil");
	}
	
	public static void main(String[] args) throws IOException {
		JedisPoolConfig poolConfig = new JedisPoolConfig();  
	    // 最大连接数  
	    poolConfig.setMaxTotal(1);  
	    // 最大空闲数  
	    poolConfig.setMaxIdle(1);  
	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：  
	    // Could not get a resource from the pool  
	    poolConfig.setMaxWaitMillis(1000);  
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7001));
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7002));
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7003));
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7004));
        jedisClusterNodes.add(new HostAndPort("47.93.249.164", 7005));
        // 使用redis集群中的任一节点即可
        JedisCluster jedis = new JedisCluster(jedisClusterNodes,poolConfig);
        //jedis.set("111", "222");
        System.out.println(jedis.get("111"));
        // 开始前，先移除所有的内容
        /*jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));

        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));*/
        
        jedis.close();
    }
}
