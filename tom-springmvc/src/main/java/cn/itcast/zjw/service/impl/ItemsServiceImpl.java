package cn.itcast.zjw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.zjw.dao.ItemsCustomerMapper;
import cn.itcast.zjw.dao.ItemsMapper;
import cn.itcast.zjw.exception.CustomException;
import cn.itcast.zjw.po.Items;
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
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsCustomerMapper itemsCustomerMapper;
	@Resource(name = "itemsMapper")
	private ItemsMapper itemsMapper;

	public ItemsCustomerMapper getItemsCustomerMapper() {
		return itemsCustomerMapper;
	}

	public void setItemsCustomerMapper(ItemsCustomerMapper itemsCustomerMapper) {
		this.itemsCustomerMapper = itemsCustomerMapper;
	}

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) {
		return itemsCustomerMapper.findItemsList(itemsQueryVo);
	}

	public ItemsCustom findItemsById(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//随着后期需求的变更,需要查询商品信息的同时,还需要查询其他信息,故这里创建Items的扩展类ItemsCustomer
		if(items == null){
			throw new CustomException("根据上传ID未能查到对应数据");
		}
		ItemsCustom itemsCustom = new ItemsCustom();
		//将Items拷贝到ItemsCustomer
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	public void updateItems(Integer id,ItemsCustom example) throws Exception {
		//写业务代码
		//对于关键的业务数据的关键性校验;
		if(id == null){
			//抛出异常,提示调用接口的用户,id不能为空;
		}
		itemsMapper.updateByPrimaryKey(example);
	}
}
