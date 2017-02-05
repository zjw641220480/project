package cn.itcast.zjw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import cn.itcast.zjw.dao.ItemsCustomerMapper;
import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:ItemsServiceImpl.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月4日下午4:57:10
 */
@Service
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsCustomerMapper itemsCustomerMapper;
	
	public ItemsCustomerMapper getItemsCustomerMapper() {
		return itemsCustomerMapper;
	}

	public void setItemsCustomerMapper(ItemsCustomerMapper itemsCustomerMapper) {
		this.itemsCustomerMapper = itemsCustomerMapper;
	}

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) {
		return itemsCustomerMapper.findItemsList(itemsQueryVo);
	}
	
}
