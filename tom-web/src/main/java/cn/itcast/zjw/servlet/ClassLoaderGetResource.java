package cn.itcast.zjw.servlet;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
/**
 * 
 * @ClassName:ClassLoaderGetResource
 * @Description:使用ClassLoader来加载类路径中的相关资源文件(相对于类路径下开始查找);
 * @author TOM
 * @Time: 2016年7月12日下午10:37:30
 */
public class ClassLoaderGetResource {
	@SuppressWarnings("deprecation")
	@Test
	public void getRespurce() throws IOException{
		ClassLoader classLoader = ClassLoaderGetResource.class.getClassLoader();
		InputStream in = classLoader.getResourceAsStream("a.txt");
		System.out.println(IOUtils.toString(in));
		in = classLoader.getResourceAsStream("cn/itcast/zjw/servlet/b.txt");
		System.out.println(IOUtils.toString(in));
		//读取Log4j.properties配置文件
		InputStream inLog4j = classLoader.getResourceAsStream("log4j.properties");
		System.out.println(IOUtils.toString(inLog4j));
	}
}
