package com.edeclare.constant.responseBody.enums;

import com.edeclare.constant.responseBody.BaseResponse;
/**
* Type: BaseResponseEnum
* Description: 枚举类禁止继承，所以类型为class，
* 	但当做Enum使用，所有枚举类的基类，设计模式：原型模式
* @author LYM
* @date Dec 17, 2018
 */
public class BaseResponseEnum {
	private BaseResponse response;

	public BaseResponseEnum(BaseResponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return response.toString();
	}
	
	public BaseResponse getResponse() {
		return response;
	}
	public void setResponse(BaseResponse response) {
		this.response = response;
	}
}
