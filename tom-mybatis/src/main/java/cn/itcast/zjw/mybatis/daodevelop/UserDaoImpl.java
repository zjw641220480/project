package cn.itcast.zjw.mybatis.daodevelop;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: UserDaoImpl 
 * @Description: Dao接口实现累,原始dao开发mybatis
 * @author Tom
 * @date 2015-12-21
 */
public class UserDaoImpl implements UserDao{
	//需要向dao实现类注入SqlSessionFactory
	//这里通过构造函数注入
	private SqlSessionFactory sqlSessionFactory = null;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}

	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();		
	}
	
}