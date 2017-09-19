package cn.itcast.zjw.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.mappers.CityMapper;
import cn.itcast.zjw.pojo.City;
import cn.itcast.zjw.service.CityService;
@Service("cityServiceImpl")
public class CityServiceImpl implements CityService{

	@Resource(name="cityMapper")
	private CityMapper cityMapper;
	
	@Override
	public City getByPrimaryKey(String cityCode) {
		return cityMapper.selectByPrimaryKey(new BigDecimal(cityCode));
	}
	
}
