package cn.itcast.tom.swagger;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.tom.pojo.Person;
import cn.itcast.tom.service.PersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication(scanBasePackages = { "cn.itcast.tom.*" }) // same as
// @Configuration+@EnableAutoConfiguration+@ComponentScan
@EnableSwagger2
public class SwaggerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Resource(name = "personServiceImple")
	private PersonService personServiceImpl;

	@ApiOperation("获取用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "Personname", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhaojigang"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "wangna") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/getPerson", method = RequestMethod.GET)
	public Person getPerson(@RequestHeader("Personname") String Personname, @RequestParam("password") String password) {
		return personServiceImpl.getPerson(Personname, password);
	}
}
