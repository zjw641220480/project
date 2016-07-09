package cn.itcast.zjw.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class StandartJdbc {
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;

	/**
	 * @Description: 最标准的JDBC操作数据库的实例;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void insert() throws Exception {
		//A:加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//B:获取连接
		String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8";
		connection = DriverManager.getConnection(url, "root", "123456");
		try {
			//设置为手动提交事务
			connection.setAutoCommit(false);
			//C:获得statement
			Statement statement = connection.createStatement();
			String sql = "insert into person(id,pname) value(122,'张俊伟')";
			//D:发送SQL语句;
			statement.executeUpdate(sql);
			System.out.println("修改成功！");
			//手动提交事务
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			//E:关闭连接;
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
