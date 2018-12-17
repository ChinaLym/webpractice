package com.edeclare.constant.responseBody.enums;

import com.edeclare.constant.responseBody.BaseResponse;
import com.edeclare.constant.responseBody.URIResponse;

/**
* Type: URIResponseEnum
* Description: 
* 	返回值为URI，需要前台做对应的事
* @author LYM
* @date Dec 17, 2018
 */
public class URIResponseEnum extends BaseResponseEnum{
	private URIResponseEnum(BaseResponse response) {
		super(response);
	}

	public static final URIResponse REDIRECT =
			new URIResponse("跳转");
}
