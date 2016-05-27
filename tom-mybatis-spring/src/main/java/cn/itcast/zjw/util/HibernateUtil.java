package cn.itcast.zjw.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		/*
		 * 1:hibernate把数据库的连接信息,映射文件的信息,持久化类的信息全部封装在一起 
		 * 2:sessionFactory是单例模式产生的;
		 * 3:一般情况下一个hibernate应该至少有一个数据库连接; 
		 * 4:该类本身是线程安全的; 
		 * 5:这个类是一个重量级的类;
		 */
	}
	/** 
	 * @MethodName:getSession
	 * @Desription:获得普通类型的session
	 * @date:2016年5月25日
	 * @author TOM
	 * @return  
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}
