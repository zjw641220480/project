package org.tom.util.test;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.tom.util.http.HttpClientUtil;

public class TFD {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("idCard", "41282319911203481X");
		param.put("name", "张俊伟");
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("idCard", "41282319911203481X"));
		list.add(new BasicNameValuePair("name", "张俊伟"));
		
		
		//参数编码
		String name = URLEncoder.encode("张俊伟");
		System.out.println(name);
		String id = URLEncoder.encode("41282319911203481X");
		System.out.println(id);
		String uri = "https://pws.payegis.com.cn/id_creditcardapi/idcard/simple_query%3FidCard%3D"+id+"%26name%3D"+name+"%26x-hmac-auth-date%3D"+System.currentTimeMillis();
		HttpGet get = new HttpGet(uri);
		get.setHeader("x-hmac-auth-date ", System.currentTimeMillis()+"");
		//6bffd7a6-d174-4d8e-b641-81f25a3dfb0a
		get.setHeader("x-hmac-auth-signature", "myei5r1：5aea3663-6791-4905-b869-71a443613e2c");
		
		
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse resp = httpClient.execute(get);
		String body = EntityUtils.toString(resp.getEntity(), "UTF-8");
		HttpClientUtil.close(resp);
		System.out.println(body);
	}
}
