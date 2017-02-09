package cn.itcast.zjw.util.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 *
 * <p>Title:CustomDateConverter.java</p>
 * <p>Description:新版本中使用Converter来进行自定义参数绑定</p>
 * @author TOM
 * @date 2017年2月9日上午10:27:08
 */
public class CustomDateConverter implements Converter<String, Date>{

	public Date convert(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
