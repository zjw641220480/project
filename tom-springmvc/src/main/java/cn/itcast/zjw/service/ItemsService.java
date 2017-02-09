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
	//根据ID查询商品信息
	public ItemsCustom findItemsById(int id) throws Exception;
	
	/**
	 * 定义Service接口,遵循单一职责,将业务参数细化,(不要使用包装类型,比如Map),以便后期让别人,让自己能迅速看懂;	
	 * @MethodName:updateItems
	 * @Description:更改商品信息
	 * @param id:修改商品的id
	 * @param itemsCustom:修改商品的信息
	 * @throws Exception
	 * @Time:2017年2月6日下午5:39:03
	 * @author:Tom
	 */
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
