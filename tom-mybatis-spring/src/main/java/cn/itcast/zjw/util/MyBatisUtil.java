/**
 * @Project: tom-mybatis-spring @(#) MyBatisUtil.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tom.util.logger.LoggerTypeEnum;
import org.tom.util.logger.LoggerUtil;

/** 
 * @ClassName: MyBatisUtil
 * @Description:
 * @Time 2016年5月22日 下午1:06:56
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class MyBatisUtil {
	private static String configPath = "SqlMapConfig.xml";
	/**
	 * @Method: getSqlSession
	 * @Description:获得SqlSession
	 * @param: @return 
	 * @return: SqlSession
	 * @date 2016年5月22日
	 * @author TOM
	 */
	public static SqlSession getSqlSession(){
		SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getInstance();
		return sqlSessionFactory.openSession();
	}
	/** 
	 * @ClassName: initSqlSessionFactory
	 * @Description:初始化SqlSessionFactory
	 * @Time 2016年5月22日 下午1:50:28
	 * @author: TOM
	 * @version 1.0.0
	 * @since  1.6
	 */
	private static class GetSqlSessionFactory{
		private static SqlSessionFactory sqlSessionFactory= initSqlSessionFactory();
		//这个方法用来给SqlSessionFactory进行初始化;
		private static SqlSessionFactory initSqlSessionFactory(){
			try {
				//这里在加载配置文件的时候注意,需要使用的是Mybatis的IO流类进行加载路径才正确
				Reader reader = Resources.getResourceAsReader(configPath);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				System.out.println("MyBatis全局配置文件找不到");
				LoggerUtil.writeToLogger(MyBatisUtil.class, LoggerTypeEnum.ERROR, "MyBatis全局配置文件找不到");
			}
			return sqlSessionFactory;
		}
		/**
		 * @Method: getInstance
		 * @Description:获得唯一的SqlSessionFactory
		 * @param: @return 
		 * @return: SqlSessionFactory
		 * @date 2016年5月22日
		 * @author TOM
		 */
		private static SqlSessionFactory getInstance(){
			return sqlSessionFactory;
		}
	}
}
