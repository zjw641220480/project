package cn.icast.zjw.test.springmapper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;

import cn.itcast.zjw.mybatis.mapper.UserMapper;
import cn.itcast.zjw.mybatis.pojo.UserCustomer;
import cn.itcast.zjw.mybatis.pojo.UserQueryVo;

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
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer user = new UserCustomer();
		user.setUsername("zhang");
		userQueryVo.setUserCustomer(user);
		userMapper.findUserList(userQueryVo);
	}
	/**
	 * 
	 * @Method:main
	 * @Description:mybatis分页插件pagehelper的使用，只需要在mybatis配置文件中引入即可
	 * @Time 2017年9月11日 上午11:27:34
	 * @author: Tom
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer user = new UserCustomer();
		PageHelper.startPage(1,4);
		userQueryVo.setUserCustomer(user);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list.size());
	}
}
