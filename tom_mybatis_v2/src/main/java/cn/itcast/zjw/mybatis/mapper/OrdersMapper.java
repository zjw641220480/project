package cn.itcast.zjw.mybatis.mapper;

import java.util.List;

import cn.itcast.zjw.mybatis.pojo.OrdersCustomer;

/**
 *
 * <p>Title:OrdersMapper.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月15日下午1:48:13
 */
public interface OrdersMapper {
	//使用resultType进行一对一的映射查询
	public List<OrdersCustomer> findOrderUserListResultType();
	//使用resultMap进行一对一的映射查询
	public List<OrdersCustomer> findOrderUserListResultMap();
	//使用resultMap进行一对多的映射查询
	public List<OrdersCustomer> findOrderUserOrdersDetailListResultMap();
	//一对一查询使用延迟加载
	public List<OrdersCustomer> findOrdersUserListLazyLoading();
	//mybatis一级缓存测试,注意:和spring整合后,是不支持一级缓存的;默认永远开启一级缓存
	public List<OrdersCustomer> firstLevelCache();
	//mybatis二级缓存测试,
	public OrdersCustomer secondLevelCache();
}
