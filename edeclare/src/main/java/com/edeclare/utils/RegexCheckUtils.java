package com.edeclare.utils;

import java.util.regex.Pattern;


/**
* Type: RegexCheckUtils
* Description: check server input
* @author LYM
* @date 2018年8月20日
*/
public class RegexCheckUtils {
	
	public static final Pattern UserAccount_PATTERN = Pattern.compile("[a-zA-Z][A-Za-z0-9]{5,17}");
	public static final Pattern Password_PATTERN = Pattern.compile("[A-Za-z0-9]{6,18}");
	public static final Pattern TransportPassword_PATTERN = Pattern.compile("[a-z0-9]{48}");
	public static final Pattern Salt_PATTERN = Pattern.compile("[A-Za-z0-9]{16}");
	public static final Pattern Email_PATTERN = Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
	public static final Pattern TelephoneNum_PATTERN = Pattern.compile("(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18\\d)\\d{8}");
	public static final Pattern IdCardNum_PATTERN = Pattern.compile("[1-9]\\d{16}(\\d|X|x)|[1-9]\\d{14}");
	public static final Pattern IPv4_PATTERN = Pattern.compile("(?=(\\b|\\D))(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))");
	public static final Pattern ZipCode_PATTERN = Pattern.compile("[0-9]{6}");
	public static final Pattern Chinese_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]{1,50}");
	public static final Pattern Chinese_Letter_Number_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]{1,50}");
	public static final Pattern AreaId_PATTERN = Pattern.compile("[123][1-6][0-9][0-9]00");
	//public static final Pattern Nickname_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5A-Za-z0-9_]{1,50}");

	
	/**
	 * 	校验地区ID
	 * @return
	 */
	public static boolean checkAreaId(String areaId){
		if(areaId == null) {
			return false;
		}
		return AreaId_PATTERN.matcher(areaId).matches();
	}
	
	/**
	 * 	校验用户详细地址
	 * @return
	 */
	public static boolean checkUserAddressInfo(String addressInfo){
		if(addressInfo == null) {
			return false;
		}
		return Chinese_Letter_Number_PATTERN.matcher(addressInfo).matches();
	}
	/**
	 * 	校验商品名称
	 * @return
	 */
	public static boolean checkProductName(String productName){
		if(productName == null) {
			return false;
		}
		return Chinese_Letter_Number_PATTERN.matcher(productName).matches();
	}
	
	
	/**
	 * 	校验邮编
	 * @return
	 */
	public static boolean checkZipCode(String zipCode){
		if(zipCode == null) {
			return false;
		}
		return ZipCode_PATTERN.matcher(zipCode).matches();
	}
	
	
	/**
	 * 	校验真实姓名
	 * @return
	 */
	public static boolean checkUserRealName(String realName){
		if(realName == null) {
			return false;
		}
		return Chinese_Letter_Number_PATTERN.matcher(realName).matches();
	}
	
	
	/**
	 * 	校验用户昵称
	 * @return
	 */
	public static boolean checkUserNickname(String nickname){
		if(nickname == null) {
			return false;
		}
		return Chinese_Letter_Number_PATTERN.matcher(nickname).matches();
	}
	
	
	/**
	 * 	校验用户名
	 * @param userAccount
	 * @return
	 */
	public static boolean checkUserAccount(String userAccount){
		if(userAccount == null) {
			return false;
		}
		return UserAccount_PATTERN.matcher(userAccount).matches();
	}
	
	/**
	 * 	校验真实密码
	 * @param password
	 * @return
	 */
	public static boolean checkUserPassword(String password){
		if(password==null) {
			return false;
		}
		return Password_PATTERN.matcher(password).matches();
	}
	
	/**
	 * 	校验盐的格式
	 * @param salt
	 * @return
	 */
	public static boolean checkSalt(String salt){
		if(salt==null) {
			return false;
		}
		return Salt_PATTERN.matcher(salt).matches();
	}
	
	/**
	 * 	校验传输密码
	 * @param transportPassword
	 * @return
	 */
	public static boolean checkTransportPassword(String transportPassword){
		if(transportPassword==null) {
			return false;
		}
		return TransportPassword_PATTERN.matcher(transportPassword).matches();
	}
	
	
	
	
	/**
	 * 	校验邮箱（简单校验）
	 * @param email
	 * @return
	 */
	public static  boolean checkEmail(String email){
		if(email==null) {
			return false;
		}
		return Email_PATTERN.matcher(email).matches();
	}
	
	/**
	 * 校验手机号	（严格校验）
	 * @param telephonNum
	 * @return
	 */
	public static  boolean checkTelephonNum(String telephoneNum){
		if(telephoneNum==null) {
			return false;
		}
		return TelephoneNum_PATTERN.matcher(telephoneNum).matches();
	}		   
	
	/**
	 * 校验身份证（严格校验）
	 * @param idCard
	 * @return
	 */
	public static  boolean checkIdCard(String idCard){
		if(idCard==null) {
			return false;
		}
		return IDCardValidator.isValidIDCard(idCard);
	}
	
	/**
	 * 校验IPv4 （严格校验）
	 * @param ipv4
	 * @return
	 */
	public static  boolean checkIPv4(String ipv4){
		if(ipv4==null) {
			return false;
		}
		return IPv4_PATTERN.matcher(ipv4).matches();
	}
/*
	public static void main(String[] args) {
		System.out.println(checkUserAccount("123123123"));
		System.out.println(checkUserAccount("A123123123"));
	}*/
}
