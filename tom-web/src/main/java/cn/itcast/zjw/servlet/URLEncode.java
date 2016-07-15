package cn.itcast.zjw.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import org.junit.Test;

public class URLEncode {
	@Test
	public void fun1() throws UnsupportedEncodingException {
		String name = "张三";
		byte[] bytes = name.getBytes("utf-8");
		System.out.println(Arrays.toString(bytes));
		//把utf-8编码的张三,重新编码为URL编码
		String s = URLEncoder.encode(name, "utf-8");
		System.out.println(s);
		//把URL编码的s重新编码为utf-8
		String s2 = URLDecoder.decode(s, "utf-8");
		System.out.println(s2);
	}
}
