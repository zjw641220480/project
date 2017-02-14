package cn.itcast.zjw.mybatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @ClassName:BaseDao
 * @Description:原始dao的开放方式中,需要把sqlSessionFactory注入到每一个dao层接口中,然后再套用原始的sqlSession方式进行开发;
 * 所有的开发方式都需要SqlSession进行开发;
 * @Time:2017年2月14日
 * @author:Tom
 */
public class BaseDao {
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public BaseDao() {
		String resource = "SqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
