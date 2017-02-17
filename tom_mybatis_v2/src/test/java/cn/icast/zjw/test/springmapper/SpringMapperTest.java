package cn.icast.zjw.test.springmapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import cn.itcast.zjw.mybatis.mapper.UserMapper;
import cn.itcast.zjw.mybatis.pojo.User;

/**
 *
 * <p>Title:SpringMapperTest.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月17日下午5:09:34
 */
public class SpringMapperTest {
	/**
	 * 
	 * @MethodName:testSpringMapperDevelop
	 * @Description:mybatis和spring整合后,mapper代理的开发方式,其代理对象由Spring容器来生成和管理
	 * @Time:2017年2月17日下午5:11:46
	 * @author:Tom
	 */
	@Test
	public void testSpringMapperDevelop(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
}
