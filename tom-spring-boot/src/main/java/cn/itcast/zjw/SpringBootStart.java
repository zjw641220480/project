package cn.itcast.zjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.init.MyBeanDefinitionRegistryPostProcessor;
import cn.itcast.zjw.pojo.WiselySettings;
import cn.itcast.zjw.pojo.WiselySettingsOther;
@ServletComponentScan //druid使用自己编写servlet和filter,listener的时候才需要这个注解；也可以作为相应servlet的注入注解
//@ImportResource("spring/applicationContext.xml")
@RestController
@MapperScan(basePackages = {"cn.itcast.zjw.mappers" })
@SpringBootApplication//等价于@Configuration，@EnableAutoConfiguration和@ComponentScan
@EnableConfigurationProperties({WiselySettings.class,WiselySettingsOther.class})
@Import({MyBeanDefinitionRegistryPostProcessor.class})
public class SpringBootStart extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStart.class, args);
	}
}
