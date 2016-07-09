package cn.itcast.zjw.project.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.project.domain.Items;
import cn.itcast.zjw.project.domain.ItemsExample;

public class ItemsMapperTest {
	private static SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis全局配置文件地址;
		String resource = "SqlMapConfig.xml";
		// 得到全局配置文件流;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂,传入mybatis全局配置文件信息(流的形式);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testDeleteByPrimaryKey() {

	}

	@Test
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		Items items = new Items();
		//主键是由mybatis进行维护,
		//items.setId(4);
		items.setName("测试");
		items.setPrice(300f);
		itemsMapper.insert(items);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testSelectByExample() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//通过criteria构造查询条件
		ItemsExample itemsExample = new ItemsExample();
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("笔记本");
		//可能返回多条记录
		List<Items> itemsList =itemsMapper.selectByExample(itemsExample);
		System.out.println(itemsList.toString());
	}

	@Test
	public void testSelectByPrimaryKey() {
		// 创建一个UserMapper代理对象;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);

		Items items = itemsMapper.selectByPrimaryKey(2);
		System.out.println(items);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//将传入的数据,对所有的字段进行更新,需要先查询出来再进行更新
		/*Items items =itemsMapper.selectByPrimaryKey(4);
		items.setName("updateByPrimaryKey");
		itemsMapper.updateByPrimaryKey(items);
		sqlSession.commit();
		sqlSession.close();*/
		//如果传入的字段不为空,才会更新;一般是在批量更新才使用;不过必须要有主键id;
		Items items = new Items();
		items.setId(6);
		items.setName("updateByPrimaryKeySelective");
		itemsMapper.updateByPrimaryKeySelective(items);
		sqlSession.commit();
		sqlSession.close();
	}
}
