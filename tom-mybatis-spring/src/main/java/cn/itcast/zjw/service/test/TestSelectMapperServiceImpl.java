package cn.itcast.zjw.service.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cn.itcast.zjw.domain.UserCustomer;
import cn.itcast.zjw.mapper.test.TestSelectMapper;
import cn.itcast.zjw.util.MyBatisUtil;

/** 
 * @ClassName:TestSelectMapperServiceImpl
 * @Description:用于测试连通性
 * @author TOM
 * @date 2016年5月23日 上午10:25:28
 * @version V1.0.0
 */ 
@Service("testSelectMapperServiceImpl")
public class TestSelectMapperServiceImpl implements TestSelectMapperInter{
	@Resource(name="testSelectMapper")
	private	TestSelectMapper testSelectMapper;
	/**
	 * Description <code>没有和Spring进行整合时候测试和数据库的连通性</code>
	 * @return List<UserCustomer>
	 * @see cn.itcast.zjw.service.test.TestSelectMapperInter#testSelect() 
	 */ 
	public List<UserCustomer> testSelect() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TestSelectMapper testSelectMapperOnlyMybatis = sqlSession.getMapper(TestSelectMapper.class);
		List<UserCustomer> lists = testSelectMapperOnlyMybatis.testSelect();
		sqlSession.close();
		return lists;
	}
	/** 
	 * @MethodName:testMybatisSpring
	 * @Desription:mybatis和Spring结合后的测试
	 * @date:2016年5月23日
	 * @author TOM
	 * @return  
	 */
	public List<UserCustomer> testMybatisSpring(){
		List<UserCustomer> lists = testSelectMapper.testSelect();
		return lists;
	}
}
