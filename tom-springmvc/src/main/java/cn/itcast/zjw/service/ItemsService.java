package cn.itcast.zjw.service;

import java.util.List;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;

/**
 *
 * <p>Title:ItemsService.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月4日下午4:56:11
 */
public interface ItemsService {
	//商品查询列表
		public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
