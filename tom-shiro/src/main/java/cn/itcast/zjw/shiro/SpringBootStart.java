package cn.itcast.zjw.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import cn.itcast.zjw.shiro.exception.MyExceptionResolver;


@ServletComponentScan
//@ImportResource(locations= {"classpath:spring/applicationContext-shiro.xml"})
@MapperScan(basePackages= {"cn.itcast.zjw.shiro.dao"})
@SpringBootApplication
public class SpringBootStart {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);
	}
	@Bean
    public MyExceptionResolver myExceptionResolver(){
        return new MyExceptionResolver();
    }
}
