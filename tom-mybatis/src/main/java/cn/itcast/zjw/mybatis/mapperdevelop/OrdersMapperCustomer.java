package cn.itcast.zjw.mybatis.mapperdevelop;

import java.util.List;

import cn.itcast.zjw.mybatis.domain.Orders;
import cn.itcast.zjw.mybatis.domain.OrdersCustomer;
import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: OrdersMapperCustomer
 * 
 * @Description: 订单的mapper.java,高级映射的配置,一对一,一对多,多对多,以及延迟加载
 * @author Tom
 * @date 2015-12-24
 */
public interface OrdersMapperCustomer {
	// 查询订单,关联查询用户,使用resultType进行映射(一对一的ResultType方式映射);
	public List<OrdersCustomer> findOrdersUserResultType() throws Exception;

	// 查询订单,关联查询用户,使用resultMap进行映射(一对一的ResultMap方式映射);
	public List<Orders> findOrdersUserResultMap() throws Exception;

	// 查询订单(关联用户)及订单明细(一对多的ResultMap方式映射),
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

	// 查询用户购买商品信息(多对多借助中间表进行映射);
	public List<User> findUserAndItemsResultMap() throws Exception;

	// 查询订单关联查询用户,用户信息是延迟加载的
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
