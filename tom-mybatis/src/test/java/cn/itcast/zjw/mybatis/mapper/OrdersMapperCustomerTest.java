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
		//����sqlSessionFactory
		//mybatisȫ�������ļ���ַ,
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�����ļ���Ϣ(������ʽ);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUserResultType() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����������
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		//����mapper.java�ķ���
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
			//��������������ص�����
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
	//��ѯ����������ѯ�û�,�û���Ϣʹ���ӳټ���
	public void testFindOrdersUserLazyLoading() throws Exception{
		//��ѯ������Ϣ----����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<Orders> list = ordersMapperCustomer.findOrdersUserLazyLoading();
		for(Orders orders:list){
			//ִ��getUserȥ��ѯ�û���Ϣ,����ʹ�����ӳټ���(�������)
			User user = orders.getUser();
			System.out.println(user);
		}
	}
}
