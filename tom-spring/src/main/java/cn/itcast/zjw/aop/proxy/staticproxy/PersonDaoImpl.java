package cn.itcast.zjw.aop.proxy.staticproxy;

import cn.itcast.zjw.base.domain.Person;
/**
 * 
 * @ClassName:PersonDaoImpl
 * @Description:静态代理的目标类,此目标类实现总接口
 * @Time:2016年8月17日
 * @author:Tom
 */
public class PersonDaoImpl implements PersonDao{

	public void savePerson(Person person) {
		System.out.println("向数据库中插入Person数据成功");
	}

}
