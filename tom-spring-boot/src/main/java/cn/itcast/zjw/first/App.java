package cn.itcast.zjw.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.controller.BaseController;
import cn.itcast.zjw.pojo.City;
/**
 * 
 * @ClassName: App.java
 * @Description:在扫描包的时候不用加*号，Spring Boot会自动扫描@SpringBootApplication所在类的同级包,以及下级包里的所有BEAN
 * @Time 2017年9月18日
 * @author: Tom
 */
@RestController
@SpringBootApplication(scanBasePackages= {"cn.itcast.zjw.first","cn.itcast.zjw.exception"})//等价于@Configuration，@EnableAutoConfiguration和@ComponentScan
public class App extends BaseController{
	Logger logger = LoggerFactory.getLogger(App.class);
	/**
	 * 
	 * @Method:hello
	 * @Description:第一个案例
	 * @Time 2017年9月18日 下午5:53:55
	 * @author: Tom
	 * @return
	 */
	@RequestMapping("/")
	public String hello() {
		return "Hello world!";
		
	}
	/**
	 * 
	 * @Method:getCityJson
	 * @Description:测试返回json数据
	 * @Time 2017年9月18日 下午5:53:45
	 * @author: Tom
	 * @return
	 */
	@RequestMapping("/json")
	public City getCityJson() {
		City city = new City();
		city.setCountry("河南");
		city.setName("TOM");
		return city;
	}
	/**
	 * 
	 * @Method:getException
	 * @Description:测试全局异常
	 * @Time 2017年9月18日 下午6:08:31
	 * @author: Tom
	 */
	@RequestMapping("/exception")
	public String getException() {
		int i = 100/0;
		return "text Exception";
	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
