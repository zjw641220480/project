package cn.itcast.zjw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;

/**
 *
 * <p>Title:ItemsCustomerMapper.java</p>
 * <p>Description:商品自定义Mapper</p>
 * @author TOM
 * @date 2017年2月4日下午4:41:26
 */
@Repository
public interface ItemsCustomerMapper {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
