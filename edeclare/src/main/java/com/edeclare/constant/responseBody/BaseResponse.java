package com.edeclare.constant.responseBody;

/**
* Type: BaseResponse
* Description:  Controller中所有添加 @ ResponseBody注解的函数，
* 			需要继承这个类.
* 		所有set方法采用链式编程方式。responseBody设计模式：适配器模式
* @author LYM
* @date Dec 17, 2018
 */
public class BaseResponse {
	//返回值说明
	private String message;
	
	public String getMessage() {
		return message;
	}
	public BaseResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	public BaseResponse(String message) {
		super();
		this.message = message;
	}
	public BaseResponse() {
		super();
	}
	
}
