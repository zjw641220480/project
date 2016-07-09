package cn.itcast.zjw.shiro.exception;


/** 
 * @ClassName: CustomException
 * @Description:系统自定义的异常类型，实际开发中可能要定义多种异常类型
 * @Time 2016年6月29日 下午9:58:55
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class CustomException extends Exception {
	
	//异常信息
	private String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
