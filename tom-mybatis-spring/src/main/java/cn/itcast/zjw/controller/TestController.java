package cn.itcast.zjw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.domain.UserCustomer;
import cn.itcast.zjw.service.mappertest.TestSelectMapperServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/test")
public class TestController {
	@Resource(name = "testSelectMapperServiceImpl")
	private TestSelectMapperServiceImpl testSelectMapperServiceImpl;

	/**
	 * @MethodName:testReturnVoid
	 * @Desription:返回void,不需要视图解析器,为绝对路径名
	 * @date:2016年5月23日
	 * @author TOM
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/testReturnVoid")
	public void testReturnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("无返回值的情况下运行");
		request.setAttribute("testRequest", "request域中存放的数据");
		List<UserCustomer> userCustomers = testSelectMapperServiceImpl.testSelect();
		System.out.println(userCustomers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @MethodName:testReturnString
	 * @Desription:返回逻辑视图名,也还需要配置视图解析器
	 * @date:2016年5月23日
	 * @author TOM
	 * @param model
	 * @return
	 */
	@RequestMapping("/testReturnString")
	public String testReturnString(Model model) {
		System.out.println("返回值为String的情况");
		model.addAttribute("testRequest", "request域中存放的数据");
		return "index";
	}

	/**
	 * @MethodName:testRequestModel
	 * @Desription:
	 * @date:2016年5月23日
	 * @author TOM
	 * @return
	 */
	@RequestMapping("/testReturnModelAndView")
	public ModelAndView testRequestModel() {
		System.out.println("返回值为ModelAndView");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("testRequest", "request域中存放的数据");
		modelAndView.setViewName("index");
		return modelAndView;
	}

	/**
	 * @MethodName:testGetResponse
	 * @Desription:get方式请求
	 * @date:2016年5月23日
	 * @author TOM
	 * @return
	 */
	@RequestMapping(value = { "/testGetResponse/{userId}" }, method = RequestMethod.GET)
	public @ResponseBody
	ApiResponse testGetResponse(@PathVariable String userId) {
		System.out.println("restFul形式的URL,GET中的参数" + userId);
		ApiResponse apiResponse = new ApiResponse();
		setApiResponse(apiResponse, "testGetResponse");
		return apiResponse;
	}

	/**
	 * @MethodName:testPostResponse
	 * @Desription:Post方式请求
	 * @date:2016年5月23日
	 * @author TOM
	 * @return
	 */
	@RequestMapping(value = { "/testPostResponse" }, method = RequestMethod.POST)
	public @ResponseBody
	ApiResponse testPostResponse(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Content-Type") String contentType, String param, HttpServletRequest request) {
		System.out.println("Head头中的内容" + encoding);
		System.out.println("Head头Content-Type值:\t" + contentType);
		System.out.println("正常参数:\t" + param);
		System.out.println("request中的参数值:\t" + request.getParameter("param"));
		System.out.println("TestController.testPostResponse()");
		ApiResponse apiResponse = new ApiResponse();
		setApiResponse(apiResponse, "testPostResponse");
		return apiResponse;
	}

	/**
	 * @MethodName:testPostResponseRequestJson
	 * @Desription:post中的体为json
	 * @date:2016年5月23日
	 * @author TOM
	 * @param userCustomer
	 * @return
	 */
	@RequestMapping(value = { "/testPostResponseJson" }, method = RequestMethod.POST)
	public @ResponseBody
	ApiResponse testPostResponseRequestJson(@RequestBody UserCustomer userCustomer) {
		System.out.println(userCustomer);
		ApiResponse apiResponse = new ApiResponse();
		setApiResponse(apiResponse, "testPostResponseJson");
		return apiResponse;
	}

	@RequestMapping(value = { "/testPostJosn" }, method = RequestMethod.POST)
	public @ResponseBody
	String testPostJosn(@RequestBody ObjectMapper objectMapper) {
		System.out.println("TestController.testPostJosn()");
		return null;
	}

	@RequestMapping(value = { "/testAll" }, method = RequestMethod.POST)
	public @ResponseBody
	ApiResponse testValidated(Model model, @Validated @RequestBody UserCustomer userCustomer,BindingResult bindingResult) {
		// 获取校验错误信息
		System.out.println(userCustomer);
		System.out.println("TestController.testValidated()");
		System.out.println(bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			// 输出校验错误信息
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : objectErrors) {
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			// 将错误信息传递到页面
			model.addAttribute("objectErrors", objectErrors);
			// 返回String进行指定jsp的时候,而且是forwar的请求转发需要加上全路径名
			ApiResponse apiResponse = new ApiResponse();
			setApiResponse(apiResponse, "testPostResponseJsonTrue");
			return apiResponse;
		}
		ApiResponse apiResponse = new ApiResponse();
		setApiResponse(apiResponse, "testPostResponseJsonFalse");
		return apiResponse;
	}

	/**
	 * @MethodName:setApiResponse
	 * @Desription:设置返回体内容
	 * @date:2016年5月23日
	 * @author TOM
	 * @param apiResponse
	 * @param requestInterface
	 */
	private void setApiResponse(ApiResponse apiResponse, String requestInterface) {
		apiResponse.setStatus(200);
		apiResponse.setMessage("OK");
		Map<String, Object> mapResult = new HashMap<String, Object>();
		mapResult.put("requestDate", formatDate());
		mapResult.put("请求的接口", requestInterface);
		apiResponse.setResult(mapResult);
	}

	/**
	 * @MethodName:formatDate
	 * @Desription:格式化返回时间
	 * @date:2016年5月23日
	 * @author TOM
	 * @return
	 */
	private String formatDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

}
