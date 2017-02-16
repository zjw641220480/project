package cn.icast.zjw.test.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.mapper.OrdersMapper;
import cn.itcast.zjw.mybatis.pojo.OrdersCustomer;

/**
 *
 * <p>Title:OrdersMapperTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月15日下午3:12:24
 */
public class OrdersMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 
	 * @Method:init
	 * @Description:初始化SqlSessionFactory
	 * @auther:TOM
	 * @date:2016年12月17日 下午2:57:57
	 * @throws IOException
	 */
	@Before
	public void init() throws IOException {
		String resource = "SqlMapConfig.xml";
		File file = Resources.getResourceAsFile(resource);
		//只有这么一种流方式来进行手动加载SqlMapConfig.xml配置文件;
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream(file));
	}

	/**
	 * 
	 * @MethodName:testFindOrderUserList
	 * @Description:ResultType实现一对一的查询结果映射,最好还是使用resultMap
	 * @Time:2017年2月15日下午3:13:12
	 * @author:Tom
	 */
	@Test
	public void testFindOrderUserListResultType() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersCustomer> customers = ordersMapper.findOrderUserListResultType();
		System.out.println(customers);
		sqlSession.close();
	}

	/**
	 * 
	 * @MethodName:testFindOrderUserListResultMap
	 * @Description:ResultMap实现一对一的查询结果映射;
	 * @Time:2017年2月15日下午3:32:47
	 * @author:Tom
	 */
	@Test
	public void testFindOrderUserListResultMap() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersCustomer> customers = ordersMapper.findOrderUserListResultMap();
		System.out.println(customers);
		sqlSession.close();
	}
	/**
	 * 
	 * @MethodName:testFindOrderUserOrdersDetailListResultMap
	 * @Description:使用resultMap进行一对多的映射
	 * @Time:2017年2月15日下午6:30:46
	 * @author:Tom
	 */
	@Test
	public void testFindOrderUserOrdersDetailListResultMap(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersCustomer> customers = ordersMapper.findOrderUserOrdersDetailListResultMap();
		System.out.println(customers);
		sqlSession.close();
	}
	/**
	 * 
	 * @MethodName:testFindOrdersUserListLazyLoading
	 * @Description:一对一查询使用延迟加载
	 * @Time:2017年2月15日下午7:51:50
	 * @author:Tom
	 */
	@Test
	public void testFindOrdersUserListLazyLoading(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersCustomer> customers = ordersMapper.findOrdersUserListLazyLoading();
		System.out.println(customers);
		sqlSession.close();
	}
}
