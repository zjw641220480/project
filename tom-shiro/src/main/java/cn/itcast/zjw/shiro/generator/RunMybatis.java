package cn.itcast.zjw.shiro.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class RunMybatis {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		String rocuse="src/main/resources/config/generatorConfig.xml";
		boolean overwrite = true;
		File configFile = new File(rocuse);
		System.out.println(configFile.length());
		System.out.println("RunMybatis.main()1111");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("RunMybatis.main()2222");
	}
	
}
