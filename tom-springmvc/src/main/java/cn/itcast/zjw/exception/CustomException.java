package cn.itcast.zjw.exception;

/**
 *
 * <p>Title:CustomException.java</p>
 * <p>Description:统一异常处理</p>
 * @author TOM
 * @date 2017年2月13日上午9:44:31
 */
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 201022792064879823L;
	//异常信息
	private String message;

	public CustomException(String message) {
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
