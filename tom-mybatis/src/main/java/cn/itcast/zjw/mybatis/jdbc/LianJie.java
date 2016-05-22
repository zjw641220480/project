package cn.itcast.zjw.mybatis.jdbc;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LianJie {
	private static ComboPooledDataSource ds=null;
	private static Properties p = new Properties();
	static{
		try {
			p.load(LianJie.class.getResourceAsStream("\\c3p0.properties"));
			System.out.println((p.getProperty("c3p0.driver")));
			ds = new ComboPooledDataSource();
			ds.setDriverClass(p.getProperty("c3p0.driver"));
			ds.setJdbcUrl(p.getProperty("c3p0.url"));
			ds.setUser(p.getProperty("c3p0.user"));
			ds.setMaxPoolSize(Integer.parseInt(p.getProperty("c3p0.maxpool")));
			ds.setMinPoolSize(Integer.parseInt(p.getProperty("c3p0.minpool")));
			ds.setPassword(p.getProperty("c3p0.password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	public synchronized static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
