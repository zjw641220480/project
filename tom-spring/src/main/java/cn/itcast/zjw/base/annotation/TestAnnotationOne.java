package cn.itcast.zjw.base.annotation;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.zjw.base.annotation.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 *
 * <p>Title:TestAnnotationOne.java</p>
 * <p>Description:获取注解上面的相关信息</p>
 * @author TOM
 * @date 2017年4月16日上午11:22:53
 */
@Component//这个注解是必须要有的,将此类加入到Spring中
public class TestAnnotationOne implements ApplicationContextAware{
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("config/base/annotation/applicationContext-Annotation.xml");
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Map<String,Object> myBatisBeans = applicationContext.getBeansWithAnnotation(MyBatis.class);
		for(Object obj:myBatisBeans.keySet()){
			String str = obj.getClass().getAnnotation(MyBatis.class).name();
			System.out.println("获得的类上的注解为:"+str);
		}
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoImpl");
		System.out.println(userDao.getUser());
	}
}
