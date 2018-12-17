package com.edeclare.constant.fieldEnum;
/**
* Type: UserSexEnum
* Description: 权限状态：[
* 保密,
* 男，
* 女，]
* @author LYM
* @date Dec 17, 2018
 */
public enum UserSexEnum {
	SECRET("保密"),			//保密
	MALE("男"),			//男
	FEMALE("女");			//女
	
	private String value;
	UserSexEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
