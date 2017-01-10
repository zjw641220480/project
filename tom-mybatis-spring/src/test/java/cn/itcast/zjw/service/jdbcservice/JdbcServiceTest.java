/**
 * @Project: tom-mybatis-spring @(#) JdbcServiceTest.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.service.jdbcservice;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.domain.UserCustomer;

/** 
 * @ClassName: JdbcServiceTest
 * @Description:
 * @Time 2016年5月24日 下午11:12:26
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class JdbcServiceTest {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"spring/applicationContext.xml");
	/**
	 * @Method: setUp
	 * @Description:
	 * @param: @throws java.lang.Exception 
	 * @return: void
	 * @date 2016年5月24日
	 * @author TOM
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertUser() {
		JdbcService jdbcService = (JdbcService) applicationContext.getBean("jdbcService");
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("女");
		userCustomer.setUsername("王金玉");
		int result = jdbcService.insertUser(userCustomer);
		System.out.println("插入数据库的条数为:\t"+result);
	}
	/** 
	 * @MethodName:testSelectPrimaryKey
	 * @Desription:测试自增主键返回,这个有问题
	 * @date:2016年5月25日
	 * @author TOM  
	 */
	@Test
	public void testSelectPrimaryKey(){
		JdbcService jdbcService = (JdbcService) applicationContext.getBean("jdbcService");
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("女");
		userCustomer.setUsername("自增主键返回");
		int primaryKey = jdbcService.selectPrimaryKey(userCustomer);
		System.out.println(primaryKey);
	}
}
