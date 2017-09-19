package cn.itcast.zjw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
/**
 * 
 * @ClassName: MyEnvironmentAware.java
 * @Description:获取Spring配置文件中的相关属性的值
 * @Time 2017年9月19日
 * @author: Tom
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware{
	//不能为static类型的
	@Value("${spring.datasource.url}")
    private String myUrl;

	public String getMyUrl() {
		return myUrl;
	}

	public void setMyUrl(String myUrl) {
		this.myUrl = myUrl;
	}

	@Override
	public void setEnvironment(Environment environment) {
		//打印注入的属性信息.

        System.out.println("myUrl="+myUrl);

        //通过 environment 获取到系统属性.

        System.out.println(environment.getProperty("JAVA_HOME"));

       

        //通过 environment 同样能获取到application.properties配置的属性.

        System.out.println(environment.getProperty("spring.datasource.url"));

        //获取到前缀是"spring.datasource." 的属性列表值.

        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource.");

        System.out.println("spring.datasource.url="+relaxedPropertyResolver.getProperty("url"));

        System.out.println("spring.datasource.driverClassName="+relaxedPropertyResolver.getProperty("driverClassName"));
	}
	
}
