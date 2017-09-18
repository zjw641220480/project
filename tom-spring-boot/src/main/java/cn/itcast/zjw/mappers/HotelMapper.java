package cn.itcast.zjw.mappers;

import cn.itcast.zjw.pojo.Hotel;

public interface HotelMapper {
    int insert(Hotel record);
    int insertSelective(Hotel record);
}