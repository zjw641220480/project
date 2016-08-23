package cn.itcast.zjw.aop.proxy.cglibproxy;

import cn.itcast.zjw.base.domain.Person;
/**
 * 
 * @ClassName:PersonDao
 * @Description:静态代理的总接口
 * @Time:2016年8月17日
 * @author:Tom
 */
public interface PersonDao {
	public void savePerson(Person person);
}
