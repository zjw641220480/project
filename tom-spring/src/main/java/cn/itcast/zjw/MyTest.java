package cn.itcast.zjw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest extends PlaceholderConfigurerSupport implements ApplicationContextAware{
	private boolean flag ;
	public static void main(String[] args) {
		Person person1 = new Person("张三1","男");
		Person person2 = new Person("张三2","男");
		Person person3 = new Person("张三3","男");
		Person person4 = new Person("张三4","男");
		List<Person> persons = new ArrayList<Person>();
		persons.add(person4);
		persons.add(person3);
		persons.add(person2);
		persons.add(person1);
		System.out.println(persons);
		int age = 10;
		for(Person person:persons){
			person.setAge(age);
			age = age +3;
		}
		System.out.println(persons);
	}
	@Test
	public void testLocations(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/base/properties/applicationContext-properties.xml");
		System.out.println(applicationContext);
		for(String key :properties.keySet()){
			System.out.println(key+"\t"+properties.get(key));
		}
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String tmp = dateFormat.format(calendar.getTime());
		System.out.println(tmp);
	}
	private static Map<String,String> properties = new HashMap<String, String>();
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
			for(Object key :props.keySet()){
				String keyStr = key.toString();
				String value = props.getProperty((String) key);
				properties.put(keyStr, value);
			}
	}
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	public ApplicationContext getApp(){
		return this.applicationContext;
	}
}
