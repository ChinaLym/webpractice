package com.edeclare.utils;

import com.alibaba.fastjson.JSON;
/**
* Type: JsonUtil
* Description: 对象与json格式的字符串转换
* @author LYM
* @date Dec 18, 2018
 */
public class JsonUtil{
	
	/**
	 * 将对象转换成json格式的字符串
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return obj == null? null:JSON.toJSONString(obj);
	}
	/**
	 * Title: toObject
	 * Description: 将json格式的字符串转换成对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public  static <T>  T toObject(String json,Class<T> clazz) {
		return json==null?null:JSON.parseObject(json, clazz);
	}

}
