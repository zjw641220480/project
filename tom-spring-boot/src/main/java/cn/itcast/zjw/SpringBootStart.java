package cn.itcast.zjw;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.config.MyEnvironmentAware;
import cn.itcast.zjw.controller.BaseController;
import cn.itcast.zjw.pojo.City;
import cn.itcast.zjw.pojo.WiselySettings;
import cn.itcast.zjw.pojo.WiselySettingsOther;
/**
 * 
 * @ClassName: App.java
 * @Description:在扫描包的时候不用加*号，Spring Boot会自动扫描@SpringBootApplication所在类的同级包,以及下级包里的所有BEAN
 * @Time 2017年9月18日
 * @author: Tom
 */
/**
 * 不连接数据库启动springboot会出现：
 * Cannot determine embedded database driver class for database type NONE  
 * 原因是：springboot启动时会自动注入数据源和配置jpa
 * 解决：在@SpringBootApplication中排除其注入
 * @SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
 * 在引入了SpringDataJpa规范的时候才需要引入上面两个包
 * ImportResouce有两种常用的引入方式：classpath和file，具体查看如下的例子：
 *	classpath路径：locations={"classpath:application-bean1.xml",
 * 		"classpath:application-bean2.xml"
 * 	}
 * file路径：
 * locations = {"file:d:/test/application-bean1.xml"};
 */
import cn.itcast.zjw.service.CityService;
import cn.itcast.zjw.servlet.MyServlet;
import cn.itcast.zjw.util.SpringUtil;
@ServletComponentScan //druid使用自己编写servlet和filter,listener的时候才需要这个注解；也可以作为相应servlet的注入注解
//@ImportResource("spring/applicationContext.xml")
@RestController
@MapperScan(basePackages = {"cn.itcast.zjw.mappers" })
@SpringBootApplication//等价于@Configuration，@EnableAutoConfiguration和@ComponentScan
@EnableConfigurationProperties({WiselySettings.class,WiselySettingsOther.class})  
public class SpringBootStart extends BaseController{
	Logger logger = LoggerFactory.getLogger(SpringBootStart.class);
	@Autowired
	private WiselySettings wiselySettings;
	@Autowired
	private WiselySettingsOther wiselySettingsOther;
	@Resource(name = "cityServiceImpl")
	private CityService  cityService;
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
	@RequestMapping("/mybatis")
	public City testMybatis() {
		return cityService.getByPrimaryKey("1");
	}
	/**
	 * 
	 * @Method:testValue
	 * @Description:获取配置文件中相关属性的值
	 * @Time 2017年9月19日 下午6:45:42
	 * @author: Tom
	 * @return
	 */
	@RequestMapping("/value")
	public String testValue() {
		MyEnvironmentAware aware = SpringUtil.getBean(MyEnvironmentAware.class);
		WiselySettings settings = SpringUtil.getBean(WiselySettings.class);
		System.out.println(settings.getName());
		System.out.println(wiselySettings.getName());
		System.out.println(wiselySettingsOther.getGender());
		return aware.getMyUrl();
	}
	/**
	 * 
	 * @Title:multipartConfigElement
	 * @Description:对文件上传的一些限制
	 * @return
	 * @author: TOM
	 * @date 2017年9月19日 下午9:49:34
	 */
	@Bean 
    public MultipartConfigElement multipartConfigElement() { 
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置单个文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("128KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256KB"); 
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig(); 
    } 
	/**
	 * 
	 * @Title:MyServlet1
	 * @Description:自己编写的servlet使用此种方式注入到容器中，servlet并不推荐使用
	 * @return
	 * @author: TOM
	 * @date 2017年9月19日 下午9:50:08
	 */
	@Bean
    public ServletRegistrationBean MyServlet1(){
           return new ServletRegistrationBean(new MyServlet(),"/myServlet/*");
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);
	}
}
