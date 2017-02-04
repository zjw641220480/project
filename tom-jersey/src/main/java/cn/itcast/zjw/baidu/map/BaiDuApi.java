package cn.itcast.zjw.baidu.map;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
@Path("/baiduapi")
public class BaiDuApi {
	private StringBuffer uri = new StringBuffer("http://api.map.baidu.com/geocoder/v2/?ak=tmVF1myxfU7E9lHXBbgzVOZ8gbFLrOkd&output=json&");
	@POST
	@Path("/longlat")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLongLat(Map<String, Object> map) throws URISyntaxException, ClientProtocolException, IOException{
		Map<String,String> params = new HashMap<String,String>();
		params.put("address", map.get("address").toString());
		params.put("callback", "showLocation");
		for(String paramkey:params.keySet()){
			uri.append(paramkey);
			uri.append("=");
			uri.append(params.get(paramkey));
			uri.append("&");
		}
		String newuri = uri.toString().substring(0,uri.lastIndexOf("&"));
		String body = this.getBody(newuri);
		return Response.status(200).entity(body).build();
	}
	@POST
	@Path("/address")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAddress(Map<String, Object> map) throws URISyntaxException, ClientProtocolException, IOException{
		Map<String,String> params = new HashMap<String,String>();
		params.put("callback", "renderReverse");
		params.put("location", map.get("lat")+","+map.get("lng"));
		params.put("pois", "1");
		for(String s:params.keySet()){
			uri.append(s);
			uri.append("=");
			uri.append(params.get(s));
			uri.append("&");
		}
		String newuri = uri.toString().substring(0,uri.lastIndexOf("&"));
		String body = this.getBody(newuri);
		System.out.println(body);
		return Response.status(200).entity(body).build();
	}
	private String getBody(String uri) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse resp = httpClient.execute(get);
		return EntityUtils.toString(resp.getEntity(), "UTF-8");
	}

}
