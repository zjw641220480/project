package cn.itcast.zjw.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.mappers.CityMapper;
import cn.itcast.zjw.pojo.City;
import cn.itcast.zjw.service.RedisService;

@Service("redisServiceImpl")
public class RedisServiceImpl implements RedisService{

	@Resource
	private CityMapper cityMapper;
	
	//@Cacheable(value="demoInfo") //缓存,这里没有指定key.
	@Override
	public City getById(BigDecimal id) {
		return cityMapper.selectByPrimaryKey(id);
	}

	//@CacheEvict(value="demoInfo")
	@Override
	public void deleteById(BigDecimal id) {
		 System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
	}

}
