package cn.itcast.zjw.response;

public class BaseResponse<T> {
	
	private int result;//标识接口调用是否成功

	private int permission;//标识用户是否具有访问权限，无权限，直接跳到登录页面
	
	private int code;

	private String message;
	
	private long totalcount;
	
	private T detail;

	public BaseResponse(){
		this.totalcount=0;
		this.message="";
	}
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(long totalcount) {
		this.totalcount = totalcount;
	}

	public T getDetail() {
		return detail;
	}

	public void setDetail(T detail) {
		this.detail = detail;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
}
