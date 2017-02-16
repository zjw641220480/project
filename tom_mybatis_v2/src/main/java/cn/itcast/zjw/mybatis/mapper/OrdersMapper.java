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
}
