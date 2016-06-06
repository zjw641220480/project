package cn.itcast.zjw.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import cn.itcast.zjw.domain.UserCustomer;
import cn.itcast.zjw.service.mappertest.TestSelectMapperServiceImpl;

public class TestSelectMapperServiceImplTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"spring/applicationContext.xml");

	/**
	 * @MethodName:testTestSelect
	 * @Desition:Mybatis没有和Spring整合时候的数据连通性测试
	 * @date:2016年5月23日
	 * @author TOM
	 */
	@Test
	public void testTestSelect() {
		//未和MyBatis整合时候使用
		TestSelectMapperServiceImpl testSelectMapperServiceImpl = new TestSelectMapperServiceImpl();
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl
				.testSelect();
		System.out.println(userCustomers);
	}

	/**
	 * @MethodName:testSqlSessionFactory
	 * @Desription:测试SqlSessionFactory是否被Spring管理成功
	 * @date:2016年5月23日
	 * @author TOM
	 */
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext
				.getBean("sqlSessionFactory");
		System.out.println(sqlSessionFactory);
	}

	/** 
	 * @MethodName:testMybatisSpring
	 * @Desription:mybatis和Spring结合后的测试
	 * @date:2016年5月24日
	 * @author TOM  
	 */
	@Test
	public void testMybatisSpring() {
		TestSelectMapperServiceImpl testSelectMapperServiceImpl = (TestSelectMapperServiceImpl) applicationContext
				.getBean("testSelectMapperServiceImpl");
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl
				.testMybatisSpring();
		System.out.println(userCustomers);
	}

	/** 
	 * @MethodName:testProperties
	 * @Desription:  属性配置文件测试
	 * @date:2016年6月6日
	 * @author TOM
	 */
	@Test
	public void testProperties() {
		@SuppressWarnings("resource")
		MessageSource resources = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		String message = resources.getMessage("tongdun.name", null, "Default",
				null);
		String mymessage = resources.getMessage("tongdun.name", null, null);
		System.out.println(message + "\tmessage");
		System.out.println(mymessage);
		System.out.println("jieshu");
		/*
		 * String message1 = resources.getMessage("msg.argument.required", new
		 * Object[] { "'联系方式'" }, null, Locale.CHINA);
		 * 
		 * System.out.println(message1);
		 */
	}
}
