package com.edeclare.constant.responseBody.enums;

import com.edeclare.constant.responseBody.BaseResponse;
import com.edeclare.constant.responseBody.UserControllerResponse;

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

	public static final UserControllerResponse SUCCESS = 
			new UserControllerResponse("成功");
	public static final UserControllerResponse FAIL = 
			new UserControllerResponse("失败");
	public static final UserControllerResponse ERROR = 
			new UserControllerResponse("错误");
	public static final UserControllerResponse EXITS = 
			new UserControllerResponse("已存在");
	public static final UserControllerResponse NON_EXISTENT = 
			new UserControllerResponse("不存在");
}
