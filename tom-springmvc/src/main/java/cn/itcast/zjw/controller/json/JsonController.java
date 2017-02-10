package cn.itcast.zjw.controller.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cn.itcast.zjw.po.ItemsCustom;

/**
 *
 * <p>Title:JsonController.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月9日下午8:05:15
 */
@Controller
@RequestMapping("/json")
public class JsonController {
	
	/**
	 * 
	 * @MethodName:requestJson
	 * @Description:用户请求json并相应json
	 * @param itemsCustom
	 * @return
	 * @Time:2017年2月10日上午9:51:47
	 * @author:Tom
	 */
	@RequestMapping("/requestJson")
	@JsonInclude(Include.NON_NULL)
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		System.out.println(itemsCustom.toString());
		return itemsCustom;
	}
}
