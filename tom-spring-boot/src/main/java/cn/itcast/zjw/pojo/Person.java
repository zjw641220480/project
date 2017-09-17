package cn.itcast.zjw.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
  * @ConfigurationProperties(prefix="user")
  * 自动读取application.properties（是spring-boot默认查找的文件）文件中的user.*的属性
  * 在没有使用@ConfigurationProperties的情况下，可以使用@Value("${user.id}")来一个个指定属性的值
  * 
  * 注意：如果要使用@ConfigurationProperties和@Value，需要将该bean添加@Component，
  * 因为在后边的对该类的使用中，需要直接将该类使用@Autowire注解注入，这样这些属性的自动注入才起作用，
  * 具体使用查看"UserService"
  * 该类就是一个普通的model，在ssm框架中我们并没有将这样的model归给spring容器去管理，在这里
  * 使用@Component注解将其交由spring容器去处理，这样在之后的使用中，就可以直接将该model注入到其使用类中。
  */
@Component("person")
@ConfigurationProperties(prefix="user")
public class Person {
	private String pid;
	private String pname;
	private String psex;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	
}	
