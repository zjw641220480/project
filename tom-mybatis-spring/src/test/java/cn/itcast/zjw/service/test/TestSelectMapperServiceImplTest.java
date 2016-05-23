package cn.itcast.zjw.service.test;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.zjw.domain.UserCustomer;

public class TestSelectMapperServiceImplTest {
	TestSelectMapperServiceImpl testSelectMapperServiceImpl = new TestSelectMapperServiceImpl();
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

	@Test
	public void testMybatisSpring() {
		TestSelectMapperServiceImpl testSelectMapperServiceImpl = (TestSelectMapperServiceImpl) applicationContext
				.getBean("testSelectMapperServiceImpl");
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl
				.testMybatisSpring();
		System.out.println(userCustomers);
	}

	@Test
	public void testProperties() {
		MessageSource resources = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		String message = resources.getMessage("tongdun.name", null, "Default",
				null);
		String mymessage = resources.getMessage("tongdun.name", null, Locale.CHINA);
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
