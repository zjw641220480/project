package cn.itcast.zjw.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
	/**
	 * 返回html模板.
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		System.out.println("TemplateController.helloHtml()");
		map.put("hello", "fromTemplateController.helloHtml");
		return "/helloHtml";
	}
}
