package cn.itcast.zjw.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;
	static {
		// 下面这两句话调用了hibernate.cfg.xml这个配置文件,从而使得持久化类和表关联了起来
		// System.out.println("HibernateUtil.enclosing_method()");
		// 创建Configuration对象然后加载hibernate的配置文件
		Configuration configuration = new Configuration();
		configuration.configure();
		// configuration.configure(".cfg.xml");
		// 这里的sessionFactory就很类似于JDBC中的connection
		// Connection conn = DriverManager.getConnection(
		// "jdbc:mysql://127.0.0.1:3308/zrcx", "root", "123456");
		sessionFactory = configuration.buildSessionFactory();
		/*
		 * 1:hibernate把数据库的连接信息,映射文件的信息,持久化类的信息全部封装在一起 
		 * 2:sessionFactory是单例模式产生的;
		 * 3:一般情况下一个hibernate应该至少有一个数据库连接; 
		 * 4:该类本身是线程安全的; 
		 * 5:这个类是一个重量级的类;
		 */
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
