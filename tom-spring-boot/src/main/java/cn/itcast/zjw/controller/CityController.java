package cn.itcast.zjw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.zjw.pojo.City;
import cn.itcast.zjw.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController extends BaseController{
	@Resource(name = "cityServiceImpl")
	private CityService cityService;
	/**
	 * 
	 * @Method:getCity
	 * @Description:
	 * @Time 2017年9月20日 下午2:20:16
	 * @author: Tom
	 * @return
	 */
	@RequestMapping("/get")
	public City getCity(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("name", "zhangsan");
		
		return cityService.getByPrimaryKey("1");
	}
}
