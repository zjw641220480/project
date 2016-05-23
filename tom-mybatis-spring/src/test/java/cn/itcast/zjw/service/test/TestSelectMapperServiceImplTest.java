package cn.itcast.zjw.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.domain.UserCustomer;

public class TestSelectMapperServiceImplTest {
	TestSelectMapperServiceImpl testSelectMapperServiceImpl = new TestSelectMapperServiceImpl();
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	/** 
	 * @MethodName:testTestSelect
	 * @Desition:Mybatis没有和Spring整合时候的数据连通性测试
	 * @date:2016年5月23日
	 * @author TOM  
	 */
	@Test
	public void testTestSelect() {
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl.testSelect();
		System.out.println(userCustomers);
	}
	/** 
	 * @MethodName:testSqlSessionFactory
	 * @Desription:测试SqlSessionFactory是否被Spring管理成功
	 * @date:2016年5月23日
	 * @author TOM  
	 */
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
		System.out.println(sqlSessionFactory);
	}
	@Test
	public void testMybatisSpring(){
		TestSelectMapperServiceImpl testSelectMapperServiceImpl = (TestSelectMapperServiceImpl) applicationContext.getBean("testSelectMapperServiceImpl");
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl.testMybatisSpring();
		System.out.println(userCustomers);
	}
}
