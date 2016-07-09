package cn.itcast.zjw.baidu.ipaddress;

import org.junit.Test;

import cn.itcast.zjw.baidu.util.BaiDuUtil;
import cn.itcast.zjw.baidu.util.UnicodeToUtf;

public class IpAddress {
	@Test
	public void testIpAddress(){
		String httpUrl = "http://apis.baidu.com/rtbasia/ip_maxcoverage/ip_maxcoverage";
		String httpArg = "ip=100.0.192.214&v=1.1";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
}
