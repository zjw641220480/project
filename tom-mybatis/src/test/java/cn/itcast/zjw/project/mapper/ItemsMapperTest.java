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
		// ����sqlSessionFactory
		// mybatisȫ�������ļ���ַ;
		String resource = "SqlMapConfig.xml";
		// �õ�ȫ�������ļ���;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����,����mybatisȫ�������ļ���Ϣ(������ʽ);
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
		//��������mybatis����ά��,
		//items.setId(4);
		items.setName("����");
		items.setPrice(300f);
		itemsMapper.insert(items);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testSelectByExample() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//ͨ��criteria�����ѯ����
		ItemsExample itemsExample = new ItemsExample();
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("�ʼǱ�");
		//���ܷ��ض�����¼
		List<Items> itemsList =itemsMapper.selectByExample(itemsExample);
		System.out.println(itemsList.toString());
	}

	@Test
	public void testSelectByPrimaryKey() {
		// ����һ��UserMapper�������;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);

		Items items = itemsMapper.selectByPrimaryKey(2);
		System.out.println(items);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//�����������,�����е��ֶν��и���,��Ҫ�Ȳ�ѯ�����ٽ��и���
		/*Items items =itemsMapper.selectByPrimaryKey(4);
		items.setName("updateByPrimaryKey");
		itemsMapper.updateByPrimaryKey(items);
		sqlSession.commit();
		sqlSession.close();*/
		//���������ֶβ�Ϊ��,�Ż����;һ�������������²�ʹ��;��������Ҫ������id;
		Items items = new Items();
		items.setId(6);
		items.setName("updateByPrimaryKeySelective");
		itemsMapper.updateByPrimaryKeySelective(items);
		sqlSession.commit();
		sqlSession.close();
	}
}
