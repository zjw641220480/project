package cn.itcast.zjw.aop.proxy.jdkproxy.jdkpersondao;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import cn.itcast.zjw.base.domain.Person;
/**
 * 问题:
 * 	1:拦截器中的invoke方法在什么时候被调用
 * 		在代理对象调用方法执行的时候,进入了拦截器中的invoke方法;
 * 	2:拦截器中的method参数是什么,在什么时候由实参传递给形参的
 * 		代理对象调用的方法名称是什么,method参数就是什么;
 * 		在代理对象调用方法执行的时候,进入了拦截器中的invoke方法,这个时候传递参数;
 * 	3:生成的代理对象实现了目标类的接口,代理对象方法体的内容是什么;
 * 		方法体的内容,就是拦截器中invoke方法体的内容;
 * 优点:
 * 	动态的产生代理对象(产生代理对象的类中并没有明确指出所代理的是哪个类,只是明确了切面;),所以只需要一个拦截器就可以了;
 * 缺点:
 * 	如果在Invoke方法中做事务的判断(哪些方法需要事务,哪些方法不需要事务),将是一个很复杂的事情;
 * 	程序员还是写拦截器了,写了拦截器中的invoke方法,所以invoke方法还需要进行修改;
 * 说明:
 *  目标类和代理类实现共同的接口,
 */
/**
 * 
 * @ClassName:TestJdkProxyPersonDao
 * @Description:第一种方式产生代理对象;
 * @Time:2016年8月17日
 * @author:Tom
 */
public class TestJdkProxyPersonDao {
	@Test
	public void testJdkProxyPersonDao(){
		//1:目标对象
		PersonDao personDao = new PersonDaoImpl();
		//2:切面
		Transaction transaction = new Transaction();
		//3:产生代理类的拦截器
		MyInterceptor myInterceptor = new MyInterceptor(personDao, transaction);
		//4:使用Proxy动态生成代理对象;此代理对象包含了目标对象中的所有属性和方法;
		//主要是是使用最后一个参数(拦截器)进行代理对象的生成;
		personDao = (PersonDao) Proxy.newProxyInstance(personDao.getClass().getClassLoader(), personDao.getClass().getInterfaces(), myInterceptor);
		Person person = new Person();
		//由于personDao是代理对象,故实际调用的是:
		//public Object invoke(Object object, Method method, Object[] args)
		personDao.savePerson(person);
	}
}
