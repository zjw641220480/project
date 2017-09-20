package cn.itcast.zjw.service;

import java.math.BigDecimal;

import cn.itcast.zjw.pojo.City;

public interface RedisService {
	public City getById(BigDecimal id);
	public void deleteById(BigDecimal id);
}
