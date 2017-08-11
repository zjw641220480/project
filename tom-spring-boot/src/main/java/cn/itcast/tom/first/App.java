package cn.itcast.tom.first;

import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
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

	public static void main(String[] args) {
		String s = "0|2|1";
		String ss[] = s.split("\\|");
		for(String str : ss){
			System.out.println(str);
		}
	//	SpringApplication.run(App.class, args);
	}
}
