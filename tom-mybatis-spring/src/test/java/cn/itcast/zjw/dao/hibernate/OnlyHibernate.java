package cn.itcast.zjw.dao.hibernate;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

/** 
 * @ClassName:OnlyHibernate
 * @Description:未和Spring进行连接时候的测试
 * @author TOM
 * @date 2016年5月25日 下午2:52:11
 * @version V1.0.0
 */ 
public class OnlyHibernate {
	/** 
	 * @MethodName:testCreateTable
	 * @Desription:测试与数据库的连通性,当数据库中表不存在时候,创建表
	 * @date:2016年5月25日
	 * @author TOM  
	 */
	@Test
	public void testCreateTable(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate/hibernate.cfg.xml");
		//生成一个连接;
		configuration.buildSessionFactory();
	}
}
