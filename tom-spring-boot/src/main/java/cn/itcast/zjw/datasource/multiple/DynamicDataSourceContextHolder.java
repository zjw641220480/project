package cn.itcast.zjw.datasource.multiple;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: DynamicDataSourceContextHolder.java
 * @Description:动态数据源上下文
 * @Time 2017年12月6日
 * @author: Tom
 */
public class DynamicDataSourceContextHolder {
	/*
	 * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
	 * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
	 */
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	/**
	 * 管理所有的数据源Id 主要是为了判断数据源是否存在
	 */
	public static List<String> dataSourceIds = new ArrayList<String>();

	/**
	 * 使用setDataSourceType设置当前的
	 * 
	 * @param dataSourceType
	 */
	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

	/**
	 * 
	 * @Method:containsDataSource
	 * @Description:判断当前DataSource是否存在
	 * @Time 2017年12月6日 下午2:42:50
	 * @author: Tom
	 * @param dataSourceId
	 * @return
	 */
	public static boolean containsDataSource(String dataSourceId) {
		return dataSourceIds.contains(dataSourceId);
	}
}
