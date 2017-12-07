package cn.itcast.zjw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {/*
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/get2")
    public String get2() {
    	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7000));
        // 使用redis集群中的任一节点即可
        JedisCluster jedis = new JedisCluster(jedisClusterNodes);
        jedis.set("111", "222");
        // 开始前，先移除所有的内容
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
        logger.info(jedis.lrange("java framework", 0, -1).toString());
        String value = jedis.get("111");
        try {
			jedis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return value;
    }
*/}
