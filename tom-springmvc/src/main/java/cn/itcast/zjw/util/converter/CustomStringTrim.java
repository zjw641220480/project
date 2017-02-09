package cn.itcast.zjw.util.converter;

import org.springframework.core.convert.converter.Converter;

/**
 *
 * <p>Title:CustomStringTrim.java</p>
 * <p>Description:使用Converter实现字符串去除前后空格</p>
 * @author TOM
 * @date 2017年2月9日上午10:30:47
 */
public class CustomStringTrim implements Converter<String, String>{

	public String convert(String source) {
		try {
			if(source!=null){
				source = source.trim();
				if(source.equals("")){
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return source;
	}
	
}
