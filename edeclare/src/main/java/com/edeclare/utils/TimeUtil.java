package com.edeclare.utils;
/**
* Type: TimeUtil
* Description: 返回按一定格式化的当前时间
* @author LYM
* @date Dec 18, 2018
 */
public class TimeUtil {
	
	/**
	 * 获取当前时间点，精确到分钟
	 * @return
	 */
	public static String getNowTime() {
		return (String.valueOf(System.currentTimeMillis())).substring(0, 8);
	}
	
	/**
	 * 获取当前时间和上一个时间点，精确到分钟，两个时间相差100s
	 * @return
	 */
	public static String[] getLastAndNowTime() {
		String result[] = new String[2];
		long nowTime = System.currentTimeMillis();
		result[1] = String.valueOf(nowTime).substring(0, 8);
		result[0] = String.valueOf(nowTime-100000).substring(0, 8);//上个时间和现在相差100秒
		return result;
	}
}
