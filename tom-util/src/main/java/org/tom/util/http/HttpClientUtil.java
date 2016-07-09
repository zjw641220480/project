package org.tom.util.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	private HttpClientUtil(){}
	/**关闭connection
	 * @param response
	 */
	public static void close(HttpResponse response) {
		try {
			if (response == null)
				return;
			if (CloseableHttpResponse.class.isAssignableFrom(response
					.getClass())) {
				((CloseableHttpResponse) response).close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 获得uri,Get中的参数是使用Map来进行封装的
	 * @param scheme
	 * @param host
	 * @param path
	 * @param uriParams
	 * @return
	 * @throws URISyntaxException
	 */
	public static String getUri(String scheme, String host, String path,
			Map<String, String> uriParams) throws URISyntaxException {
		StringBuffer str = new StringBuffer();
		str.append(scheme).append("://").append(host).append(path);
		if(uriParams != null){
			str.append("?");
			for(String key:uriParams.keySet()){
				str.append(key).append("=").append(uriParams.get(key)).append("&");
			}
			return str.toString().substring(0,str.lastIndexOf("&"));
		}
		return str.toString();
	}
	/**
	 * 将json串中的参数设置到Post体中,传递的参数直接是json串
	 * @param uri
	 * @param jsonPostParams
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getPostBody(String uri,String jsonPostParams) throws ClientProtocolException, IOException{
		HttpPost post = new HttpPost(uri);
		post.setHeader("Content-Type","application/json;charset=utf-8");
		post.setHeader("Accept", "application/json");
		if(jsonPostParams!=null&&!jsonPostParams.trim().equals("")){
			post.setEntity(new StringEntity(jsonPostParams,Charset.forName("UTF-8")));
		}
		return getBody(post);
	}
	/**
	 * 将List<NameValuePair>类型的post参数添加到Post体中
	 * @param uri
	 * @param list
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getPostBody(String uri,List<NameValuePair> list) throws ClientProtocolException, IOException{
		HttpPost post = new HttpPost(uri);
		if(list!=null&&list.size()!=0){
			post.setEntity(new UrlEncodedFormEntity(list,Charset.forName("UTF-8")));
		}
		return getBody(post);
	}
	/**
	 * 获得get请求返回的体;
	 * @param uri
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getGetBody(String uri) throws ClientProtocolException, IOException{
		HttpGet get = new HttpGet(uri);
		return getBody(get);
	}
	private static String getBody(HttpRequestBase request) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse resp = httpClient.execute(request);
		String body = EntityUtils.toString(resp.getEntity(), "UTF-8");
		HttpClientUtil.close(resp);
		return body;
	}
}
