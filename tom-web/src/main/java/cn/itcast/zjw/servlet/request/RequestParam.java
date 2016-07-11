package cn.itcast.zjw.servlet.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @ClassName:RequestParam
 * @Description:此类主要是用来演示获取各个提交方式的请求参数;
 * @author TOM
 * @Time: 2016年7月11日下午9:49:00
 */
public class RequestParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RequestParam() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		System.out.println(this.toString());
		System.out.println("RequestParam.doGet()");
		String param = null;
		while(paramNames.hasMoreElements()){
			param = request.getParameter(paramNames.nextElement());
			System.out.println("获得的GET方式URL提交的参数为\t"+param);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.toString());
		System.out.println("RequestParam.doPost()");
		String[] hobbyValues = request.getParameterValues("hobby");
		System.out.println("爱好\t"+Arrays.toString(hobbyValues));
		
		Map<String,String[]> mapParams = request.getParameterMap();
		Set<String> params= mapParams.keySet();
		for(String param:params){
			String[] paramValue = mapParams.get(param);
			System.out.println(param+"\t\t"+Arrays.toString(paramValue));
		}
	}
}
