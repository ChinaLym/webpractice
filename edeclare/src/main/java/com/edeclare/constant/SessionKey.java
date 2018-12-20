package com.edeclare.constant;
/**
* Type: SessionKey
* Description: Session中的setAttribute(key, value)和session.getAttribute(key)中的key
* 	必须在该类中列出并注释
* @author LYM
* @date Dec 20, 2018
 */
public class SessionKey {

	//存放登录的用户
	public static final String USER = "user";
	
	//存放token字段
	public static final String TOKEN = "token";
	
	private SessionKey() {}
}
