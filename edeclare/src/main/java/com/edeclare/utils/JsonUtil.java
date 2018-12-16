package com.edeclare.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtil{
	
	/**
	 * 将对象转换成json格式的字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return obj == null? null:JSON.toJSONString(obj);
	}
	//将json格式的字符串转换成对象
	public  static <T>  T toObject(String json,Class<T> clazz) {
		return json==null?null:JSON.parseObject(json, clazz);
	}

}
