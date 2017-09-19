package cn.itcast.zjw.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.zjw.response.BaseResponse;

/**
 * 
 * @ClassName: GlobalDefaultExceptionHandler.java
 * @Description:全局异常处理
 * @Time 2017年9月19日
 * @author: Tom
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	@ExceptionHandler({ SQLException.class })
	public String databaseError() {
		return "databaseError";
	}
	@ExceptionHandler({ RuntimeException.class })
	public BaseResponse<Object>  runTimeError(RuntimeException exception) {
		BaseResponse<Object> baseResponse = new BaseResponse<Object>();
		baseResponse.setDetail("运行时异常");
		System.out.println(exception.toString());
		return baseResponse;
	}
	// Total control - setup a model and return the view name yourself. Or consider
	// subclassing ExceptionHandlerExceptionResolver (see below).
	@ExceptionHandler(value = Exception.class)
	public BaseResponse<Object> handleError(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);

		BaseResponse<Object> baseResponse = new BaseResponse<Object>();
		baseResponse.setResult(0);
		baseResponse.setCode(-99);
		baseResponse.setMessage("系统异常，请联系管理员");
		baseResponse.setDetail(exception.toString());
		return baseResponse;
	}
}
