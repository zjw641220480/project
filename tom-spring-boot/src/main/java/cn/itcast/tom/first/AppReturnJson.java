package cn.itcast.tom.first;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.tom.pojo.Person;

/**
 * @RestController:spring mvc的注解，
 * 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/demo")
@SpringBootApplication(scanBasePackages={"cn.itcast.tom.*"})
public class AppReturnJson {
	
	@Resource(name="person")
	//@Autowired
	private Person person ;
	
	 /**

     *返回demo数据:

     *请求地址：http://127.0.0.1:8080/demo/getDemo

     *@return

     */
	//在方法上使用@Bean注解可以让方法的返回值为单例，
	//该方法的返回值可以直接注入到其他类中去使用
	//@Bean注解是方法级别的
    @RequestMapping("/getDemo")
    public Person getDemo(){

       Person demo = new Person();

       demo.setPid("111");

       demo.setPname("Angel");

       return person;

    }
    
    public static void main(String[] args) {
		SpringApplication.run(AppReturnJson.class, args);
	}
}
