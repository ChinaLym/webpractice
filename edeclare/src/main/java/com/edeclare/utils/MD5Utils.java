package com.edeclare.utils;
 
import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
 
/**
 * MD5加密解密工具类
 */
public class MD5Utils {

	/**
	 * 普通MD5加密 01
	 */
	public static String getStrMD5(String inStr) {
		// 获取MD5实例
		MessageDigest md5 = null;
		byte[] byteArray;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byteArray = inStr.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
 
		// 开始加密
		byte[] digest = md5.digest(byteArray);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			int var = digest[i] & 0xff;
			if (var < 16)
				sb.append("0");
			sb.append(Integer.toHexString(var));
		}
		return sb.toString();
	}
 
	/**
	 * 普通MD5加密 02
	 */
	public static String getStrrMD5(String password) {
 
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte strTemp[] = password.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte md[] = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}
 
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
 
	/**
	 * MD5双重解密
	 */
	public static String getconvertMD5(String inStr) {
		char[] charArray = inStr.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = (char) (charArray[i] ^ 't');
		}
		String str = String.valueOf(charArray);
		return str;
	}
 
	/**
	 * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
	 */
	private static String md5Hex(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(str.getBytes());
			return new String(new Hex().encode(digest));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
 
	/**
	 * s
	 * 生成一个16位的盐
	 * @return
	 */
	public static String getNewSalt() {
		Random random = new Random();
		StringBuilder sBuilder = new StringBuilder(16);
		sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
		int len = sBuilder.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				sBuilder.append("0");
			}
		}
		// 生成最终的加密盐
		return sBuilder.toString();
	}
	
	/**
	 * 加盐MD5加密
	 * 使用指定盐加密
	 * 	result = mad5(pass + salt) + salt 融合
	 * 	融合算法待更新
	 */
	public static String getSaltMD5(String password,String salt) {
		// 生成一个16位的随机数
		password = md5Hex(password + salt);
		char[] cs = new char[48];
		char c ;
		for (int i = 0; i < 48; i += 3) {
			cs[i] = password.charAt(i / 3 * 2);
			c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
		}
		return String.valueOf(cs);
	}
	/**
	 * 
	 * 加盐MD5加密
	 * 使用随机盐加密，并把该盐融入字符串中
	 */
	public static String getSaltMD5(String password) {
		return getSaltMD5(password,getNewSalt());
	}
	
	//======================二代算法2018年8月26日22:02:36
	//xxxxxxxxxxxxxxxxxxxxxx已放弃更新
	/**
	 * 	返回 密盐+密码的md5值
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String getSaltMD5_2(String password,String saltPlus) {
		// 生成一个16位的随机数
		return md5Hex(saltPlus + password);
		
	}
	
	/**
	 * 	把盐转化为密盐，即数据库中保存的salt
	 * 	该算法为简单地将16位盐的前6位和9-14位换一下位置，可逆(调用2次即可)
	 * @param salt
	 * @return
	 */
	public static String getSaltPlus(String salt) {
		if(salt.length()!=16)return salt;
		char c[] = salt.toCharArray();
		char temp;
		for(int i = 0; i < 6; i++) {
			temp = c[i];
			c[i] = c[8 + i];
			c[8 + i] = temp;
		}
		return new String(c);
	}

	/**
	 * 验证加盐后是否和原文一致
	 */
	public static boolean getSaltverifyMD5(String password, String md5str) {
		try {
			char[] cs1 = new char[32];
			char[] cs2 = new char[16];
			for (int i = 0; i < 48; i += 3) {
				cs1[i / 3 * 2] = md5str.charAt(i);
				cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
				cs2[i / 3] = md5str.charAt(i + 1);
			}
			String Salt = new String(cs2);
			return md5Hex(password + Salt).equals(String.valueOf(cs1));
		}catch(Exception e) {
			return false;
		}
	}
 

	
	/**
	 * 验证当前网络传输收到的密码是否和数据库中密码一致,允许0s—200s的时间差
	 * 若两者有为空则返回false(逻辑在底层中)
	 * @return
	 */
	public static boolean verifyPass(String transportPass,String db_pass) {
		String[] time = TimeUtil.getLastAndNowTime();
		return MD5Utils.getSaltverifyMD5((db_pass + time[1]),transportPass)||
				MD5Utils.getSaltverifyMD5((db_pass + time[0]),transportPass);
	
	}
	
	/*
	public static void main(String[] args) throws EncoderException {
		//模拟前台加密
		String password = "abc123456";
		String salt =null;// MD5Utils.getNewSalt();
		salt = "2223331110456321";
		String db_default_pass = MD5Utils.getSaltMD5(password,salt);
		System.out.println(db_default_pass);
		String tanspass = MD5Utils.getSaltMD5(db_default_pass+TimeUtil.getNowTime());
		System.out.println(tanspass);
		System.out.println("Time = " + TimeUtil.getNowTime());
		//模拟后台解密
		System.out.println(verifyPass(tanspass,db_default_pass));
		System.out.println("+++++++++++++++++++");
		//测试对比
		String tp = "24d92d989045d7820555074821316eb2c22ca1e02394ce28";
		System.out.println(verifyPass(tp,getSaltMD5("111111","8749917209272064")));
		//System.out.println(getSaltMD5("111111","8749917209272064"));
		//
		System.out.println(tp.length());
		//System.out.println(MD5Utils.getSaltMD5(password));
		String saltx = "1234567890123456";
		String saltxplus = getSaltPlus(saltx);
		System.out.println(saltxplus);
		System.out.println(getSaltPlus(saltxplus));
		
	}*/
}
