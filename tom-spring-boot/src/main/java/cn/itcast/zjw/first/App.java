package cn.itcast.zjw.first;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//没有这个注解的时候,不能正确返回字符串,不能解析
@SpringBootApplication(scanBasePackages={"cn.itcast.tom.*"})
class App {
	@RequestMapping("/first")
	String home() {
		System.out.println("App.home()");
		return "hello";
	}

}
