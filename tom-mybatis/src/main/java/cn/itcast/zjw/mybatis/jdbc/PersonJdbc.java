package cn.itcast.zjw.mybatis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PersonJdbc {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	/**
	 * @Description: 使用连接池来简化Jdbc操作数据库
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016年4月17日
	 */
	@Test
	public void insert() {
		conn = LianJie.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into person(pid,pname) value(14,'张俊伟')";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, ps);
		}
	}
}
