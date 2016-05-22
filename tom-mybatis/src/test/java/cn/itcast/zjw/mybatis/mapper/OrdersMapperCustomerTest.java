package cn.itcast.zjw.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.Orderdetail;
import cn.itcast.zjw.mybatis.domain.Orders;
import cn.itcast.zjw.mybatis.domain.OrdersCustomer;
import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.mapperdevelop.OrdersMapperCustomer;

public class OrdersMapperCustomerTest {
	private static SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUp()throws Exception{
		//创建sqlSessionFactory
		//mybatis全局配置文件地址,
		String resource = "SqlMapConfig.xml";
		//得到配置文件流;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis配置文件信息(流的形式);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUserResultType() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		//调用mapper.java的方法
		List<OrdersCustomer> list = ordersMapperCustomer.findOrdersUserResultType();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindOrdersUserResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<Orders> list = ordersMapperCustomer.findOrdersUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer =sqlSession.getMapper(OrdersMapperCustomer.class);
		List<Orders> list = ordersMapperCustomer.findOrdersAndOrderDetailResultMap();
		//System.out.println(list);
		for(Orders o:list){
			System.out.println(o);
			//这里存在有懒加载的问题
			for(Orderdetail ord:o.getOrderDetails()){
				System.out.println(ord);
			}
			System.out.println("***********************");
		}
		sqlSession.close();
	}
	@Test
	public void testFindUserAndItemsResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<User> list = ordersMapperCustomer.findUserAndItemsResultMap();
		System.out.println(list.size());
		sqlSession.close();
	}
	@Test
	//查询订单关联查询用户,用户信息使用延迟加载
	public void testFindOrdersUserLazyLoading() throws Exception{
		//查询订单信息----单表
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<Orders> list = ordersMapperCustomer.findOrdersUserLazyLoading();
		for(Orders orders:list){
			//执行getUser去查询用户信息,这里使用了延迟加载(按需加载)
			User user = orders.getUser();
			System.out.println(user);
		}
	}
}
