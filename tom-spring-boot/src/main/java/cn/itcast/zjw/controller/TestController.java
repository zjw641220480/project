package cn.itcast.zjw.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.SpringBootStart;
import cn.itcast.zjw.datasource.simple.Shanhy;
import cn.itcast.zjw.pojo.City;
import cn.itcast.zjw.pojo.WiselySettings;
import cn.itcast.zjw.pojo.WiselySettingsOther;
import cn.itcast.zjw.service.CityService;
import cn.itcast.zjw.service.RedisService;
import cn.itcast.zjw.servlet.MyServlet;

@RestController
public class TestController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(SpringBootStart.class);
	
	@Resource(name="shanhyA")
	private Shanhy shanhy;
	
	@Autowired
	private WiselySettings wiselySettings;
	
	@Autowired
	private WiselySettingsOther wiselySettingsOther;
	
	@Resource(name = "cityServiceImpl")
	private CityService  cityService;
	
	@Resource(name = "redisServiceImpl")
	private RedisService redisService;
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
		shanhy.display();
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
		System.out.println("SpringBootStart.testMybatis()");
		return cityService.getByPrimaryKey("1");
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
	@RequestMapping("/redisSet")
	public City getCityByRedis() {
		return redisService.getById(new BigDecimal("1"));
	}
	@RequestMapping("/redisDel")
	public void delCityByRedis() {
		redisService.deleteById(new BigDecimal("1"));
	}
    
}
