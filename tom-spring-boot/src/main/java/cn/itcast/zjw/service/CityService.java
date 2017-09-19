package cn.itcast.zjw.service;

import cn.itcast.zjw.pojo.City;

public interface CityService {
	City getByPrimaryKey(String cityCode);
}
