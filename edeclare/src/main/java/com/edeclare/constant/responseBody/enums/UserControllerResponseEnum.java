package com.edeclare.constant.responseBody.enums;

import com.edeclare.constant.responseBody.BaseResponse;

/**
* Type: UserControllerResponseEnum
* Description: 
* 	UserController中所有的ResponseBody注解过的方法，
* 	只能返回该枚举类中出现的值
* @author LYM
* @date Dec 17, 2018
 */
public class UserControllerResponseEnum extends BaseResponseEnum{
	public UserControllerResponseEnum(BaseResponse response) {
		super(response);
	}

}
