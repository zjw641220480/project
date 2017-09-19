package cn.itcast.zjw.druid.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 
 * @ClassName: DruidStatFilter.java
 * @Description:druid过滤器.
 * @Time 2017年9月19日
 * @author: Tom
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
		initParams = {
				@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
		}
)
public class DruidStatFilter extends WebStatFilter {

}
