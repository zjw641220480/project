package cn.itcast.zjw.mybatis.mapperdevelop;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.Orders;
import cn.itcast.zjw.mybatis.domain.OrdersCustomer;

public class TestOrdersMapperCustomer {
	private SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void beforeTest() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	/**
	 * @Description: 一对一查询,使用ResultType作为返回结果映射
	 * @return void  
	 * @throws Exception 
	 * @throws
	 * @author Tom
	 * @date 2016年4月20日
	 */
	@Test
	public void testFindOrdersUserResultType() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<OrdersCustomer> list = ordersMapperCustomer.findOrdersUserResultType();
		System.out.println(list.get(0).getOrdername());
		System.out.println(list);
	}
	/**
	 * @Description: 一对一查询,使用ResultMap作为返回结果映射
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月20日
	 */
	@Test
	public void testFindOrdersuserResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
		List<Orders> list = ordersMapperCustomer.findOrdersUserResultMap();
		System.out.println(list);
	}
}
