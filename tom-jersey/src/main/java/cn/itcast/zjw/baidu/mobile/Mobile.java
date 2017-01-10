package cn.itcast.zjw.baidu.mobile;

import org.junit.Test;

import cn.itcast.zjw.baidu.util.BaiDuUtil;
import cn.itcast.zjw.baidu.util.UnicodeToUtf;

public class Mobile {
	//http://apistore.baidu.com/apiworks/servicedetail/117.html
	@Test
	public void tesPhoneSimble(){
		String httpUrl = "http://apis.baidu.com/apistore/mobilephoneservice/mobilephone";
		String httpArg = "tel=15516861580";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
	//http://apistore.baidu.com/apiworks/servicedetail/709.html
	@Test
	public void testPhoneDetail(){
		String httpUrl = "http://apis.baidu.com/showapi_open_bus/mobile/find";
		String httpArg = "num=15516861580";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
	//http://apistore.baidu.com/apiworks/servicedetail/794.html
	@Test
	public void testPhone(){
		String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
		String httpArg = "phone=15210011578";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
	@Test
	public void testRUn(){
		String httpUrl = "http://apis.baidu.com/lbs_repository/cell/query";
		String httpArg = "mcc=460&mnc=1&lac=4301&ci=20986&coord=wgs84";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
}
