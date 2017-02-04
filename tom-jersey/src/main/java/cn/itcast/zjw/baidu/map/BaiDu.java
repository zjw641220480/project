package cn.itcast.zjw.baidu.map;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.tom.util.http.HttpClientUtil;

import cn.itcast.zjw.baidu.util.UnicodeToUtf;

@Path("/baidu")
public class BaiDu {
	@POST
	@Path("/longlat")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getLongLat(@FormParam("address")String address) throws URISyntaxException, ClientProtocolException, IOException{
		Map<String,String> params = new HashMap<String,String>();
		params.put("address", address);
		params.put("output", "json");
		params.put("ak", "tmVF1myxfU7E9lHXBbgzVOZ8gbFLrOkd");
		params.put("callback", "showLocation");
		String uri = HttpClientUtil.getUri("http", "api.map.baidu.com", "/geocoder/v2/", params);
		String body = HttpClientUtil.getGetBody(uri);
		System.out.println(body);
	}
	@POST
	@Path("/address")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getAddress(@FormParam("lat") String lat,@FormParam("lng") String lng) throws URISyntaxException, ClientProtocolException, IOException{
		Map<String,String> params = new HashMap<String,String>();
		params.put("ak", "tmVF1myxfU7E9lHXBbgzVOZ8gbFLrOkd");
		params.put("callback", "renderReverse");
		params.put("location", lat+","+lng);
		params.put("output", "json");
		params.put("pois", "1");
		StringBuffer uri = new StringBuffer("http://api.map.baidu.com/geocoder/v2/?");
		for(String s:params.keySet()){
			uri.append(s);
			uri.append("=");
			uri.append(params.get(s));
			uri.append("&");
		}
		String newuri = uri.toString().substring(0,uri.lastIndexOf("&"));
		String body = HttpClientUtil.getGetBody(newuri);
		System.out.println(body);
	}
	//http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException {
		BaiDu baiDu = new BaiDu();
		baiDu.getLongLat("嘉兴美福汽车有限公司");//{"lng":120.81187918728,"lat":30.732934262569}
		//baiDu.getLongLat("河南省驻马店市遂平县阳丰乡朱屯村");
		baiDu.getAddress("30.732934262569","120.81187918728");//{"lng":120.81187922501,"lat":30.732934133127}
	}
	
	//http://lbsyun.baidu.com/index.php?title=webapi/route-matrix-api
	@Test
	public void getDistance() throws URISyntaxException, ClientProtocolException, IOException{
		/*Map<String,String> params = new HashMap<String,String>();
		params.put("origins", "30.732934262569,120.81187918728");
		params.put("destinations", "30.732934133127,120.81187922501");
		params.put("ak", "tmVF1myxfU7E9lHXBbgzVOZ8gbFLrOkd");
		params.put("output", "json");*/
		//String uri = HttpClientUtil.getUri("http", "api.map.baidu.com", "/direction/v1/routematrix", params);
		String uri = "http://api.map.baidu.com/direction/v1/routematrix?ak=tmVF1myxfU7E9lHXBbgzVOZ8gbFLrOkd&destinations=30.732934133127,120.81187922501&origins=30.732934262569,120.81187918728&output=json";
		System.out.println(uri);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse resp = httpClient.execute(get);
		String jsonResult = EntityUtils.toString(resp.getEntity(), "UTF-8");
		String body = UnicodeToUtf.decodeUnicode(jsonResult);
		HttpClientUtil.close(resp);
		System.out.println(body);
	}
}