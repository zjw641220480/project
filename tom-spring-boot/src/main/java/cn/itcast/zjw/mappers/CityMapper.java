package cn.itcast.zjw.mappers;

import cn.itcast.zjw.pojo.City;
import java.math.BigDecimal;

public interface CityMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}