package cn.itcast.zjw.controller;


import cn.itcast.zjw.response.BaseResponse;

public class BaseController {
	/**
	 * 默认返回一个成功的对象
	 * @return
	 */
	protected BaseResponse<Object> success() {
		BaseResponse<Object> baseResponse = new BaseResponse<Object>();
		baseResponse.setResult(1);
		baseResponse.setCode(0);
		baseResponse.setPermission(1);
		baseResponse.setMessage("操作成功");
		return baseResponse;
	}
	/**
	 * 操作异常
	 * @param e
	 * @return
	 */
	protected BaseResponse<Object> failed(Exception e) {
		BaseResponse<Object> baseResponse = new BaseResponse<Object>();
		baseResponse.setResult(0);
		baseResponse.setCode(-99);
		baseResponse.setMessage("系统异常，请联系管理员");
		baseResponse.setDetail(e.getMessage());
		return baseResponse;
	}
}
