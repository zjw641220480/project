package cn.itcast.zjw.baidu.card;

import org.junit.Test;

import cn.itcast.zjw.baidu.util.BaiDuUtil;
import cn.itcast.zjw.baidu.util.UnicodeToUtf;

public class BaiDuIdCard {
	//http://apistore.baidu.com/apiworks/servicedetail/1618.html
	@Test
	public void testIdCard(){
		String httpUrl = "http://apis.baidu.com/chazhao/idcard/idcard";
		String httpArg = "idcard=430224198508085219";
		String jsonResult = BaiDuUtil.request(httpUrl, httpArg);
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		System.out.println(body);
	}
}
