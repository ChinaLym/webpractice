package com.edeclare.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试校验身份证合法性的小程序
 * <p>我们常用的身份证号码为18位或者15位</p> <p>下面的程序仅仅用于校验18为的身份证的合法性</p>
 * @author LYM
 * @date 2018年8月27日10:07:06
 * @Version 1.0
 */
public class IDCardValidator {
		static final Map<String,String> AREA_CODE_MAP = new HashMap<String,String>();
		static {
			AREA_CODE_MAP.put("11", "北京");   
	        AREA_CODE_MAP.put("12", "天津");   
	        AREA_CODE_MAP.put("13", "河北");   
	        AREA_CODE_MAP.put("14", "山西");   
	        AREA_CODE_MAP.put("15", "内蒙古");   
	        AREA_CODE_MAP.put("21", "辽宁");   
	        AREA_CODE_MAP.put("22", "吉林");   
	        AREA_CODE_MAP.put("23", "黑龙江");   
	        AREA_CODE_MAP.put("31", "上海");   
	        AREA_CODE_MAP.put("32", "江苏");   
	        AREA_CODE_MAP.put("33", "浙江");   
	        AREA_CODE_MAP.put("34", "安徽");   
	        AREA_CODE_MAP.put("35", "福建");   
	        AREA_CODE_MAP.put("36", "江西");   
	        AREA_CODE_MAP.put("37", "山东");   
	        AREA_CODE_MAP.put("41", "河南");   
	        AREA_CODE_MAP.put("42", "湖北");   
	        AREA_CODE_MAP.put("43", "湖南");   
	        AREA_CODE_MAP.put("44", "广东");   
	        AREA_CODE_MAP.put("45", "广西");   
	        AREA_CODE_MAP.put("46", "海南");   
	        AREA_CODE_MAP.put("50", "重庆");   
	        AREA_CODE_MAP.put("51", "四川");   
	        AREA_CODE_MAP.put("52", "贵州");   
	        AREA_CODE_MAP.put("53", "云南");   
	        AREA_CODE_MAP.put("54", "西藏");   
	        AREA_CODE_MAP.put("61", "陕西");   
	        AREA_CODE_MAP.put("62", "甘肃");   
	        AREA_CODE_MAP.put("63", "青海");   
	        AREA_CODE_MAP.put("64", "宁夏");   
	        AREA_CODE_MAP.put("65", "新疆");   
	        AREA_CODE_MAP.put("71", "台湾");   
	        AREA_CODE_MAP.put("81", "香港");   
	        AREA_CODE_MAP.put("82", "澳门");   
	        AREA_CODE_MAP.put("91", "国外");
		}
		static final String NUMBER_WITH_X = "[0-9]*(X)?";
		static final String NUMBERS = "[0-9]*";
		static final Pattern NUMBERS_PATTERN = Pattern.compile(NUMBERS);
		static final Pattern NUMBER_WITH_X_PATTERN = Pattern.compile(NUMBER_WITH_X);
		/**
		 * 根据areaCode获得地区
		 * @param areaCode
		 * @return
		 */
		public static String getAreaByCode(String areaCode) {
			return AREA_CODE_MAP.get(areaCode);
		}
		
		/*
	    private static Map<String, String> getAreaCode() {   
	        return AREA_CODE_MAP;   
	    }
	    */
	    
	    /**
	     * 功能:校验地区码是否合法
	     * @param idCard 身份证号码
	     * @return true:合法,false:非法
	     */
	    public static boolean isValidAreaCode(String idCard){
	    	return AREA_CODE_MAP.containsKey(idCard.substring(0,2));
	    }
	    
	    /**  
		 * @param idCard 身份证号码
		 * @return true:数字,false:含有非数字
		 */
		public static boolean isNumberOrLetterX(String idCard){
			boolean flag = false;
			Matcher m = NUMBER_WITH_X_PATTERN.matcher(idCard);
			if(m.matches()){
				flag=true;
			}
			return flag;
		}
		
		/**
		 * 校验输入的身份证号码是否都是数字
		 * @param idCard 身份证号码
		 * @return true:数字,false:含有非数字
		 */
		public static boolean isValidNumber15(String idCard){
			boolean flag = false;
			if(idCard.length()!=15){
				//System.out.println("身份证号码长度必须为15");
				return flag;
			}
			Matcher m = NUMBERS_PATTERN.matcher(idCard);
			if(m.matches()){
				flag=true;
			}
			return flag;
		}
		/**
		 * 功能:校验身份证号码的出生年-月-日是否合法
		 * @param idCard 身份证号码
		 * @return 合法与否
		 */
		public static boolean isValidDateOfBirth(String idCard){
			int year;
			int month;
			int day;
			if(idCard.length()==15) {
				year = 1900 + Integer.parseInt(idCard.substring(6,8));
				month = Integer.parseInt(idCard.substring(8, 10));
				day = Integer.parseInt(idCard.substring(10,12));
			}else if(idCard.length()==18){
				year = Integer.parseInt(idCard.substring(6,10));
				month = Integer.parseInt(idCard.substring(10, 12));
				day = Integer.parseInt(idCard.substring(12,14));
			}else {
				return false;
			}
				
			
			//年份的话,仅仅设定区间为向前200年
			Date date = new Date();
			SimpleDateFormat simple = new SimpleDateFormat("yyyy");
			String formatDate = simple.format(date);
			int nowYear = Integer.parseInt(formatDate);
			if(year<nowYear-200 || year>nowYear){
				return false;
			}
			if(month>12 || month<1){
				return false;
			}
			if(day>31 || day<1){
				return false;
			}
			return true;
		}
	
	/**17位数字的本体码权重*/
	private static final int[] WEIGHT = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
	
	/**求和之后mod 11的对应最后一位合法位的字符,下标分别为Y: 0 1 2 3 4 5 6 7 8 9 10 */
	private static final char[] VALIDATE = {'1','0','X','9','8','7','6','5','4','3','2'};
	
	public static final String ID_CARD_NUMBER_REGEX = "[1-9]\\d{16}(\\d|X|x)|[1-9]\\d{14}";
	/**
	 * 校验身份证是否合法
	 * * 规则：
		 * 	是不是正确的身份证格式
		 * 	
		 * 	验证地区码，校验年月日
		 * 
		 * 	若18位，验证校验码
	 * @param idCard 输入需要校验的身份证号码(仅仅位18位长度的时候)
	 * @return true:合法,false:非法
	 */
	public static boolean isValidIDCard(String idCard){
		if(Pattern.matches(ID_CARD_NUMBER_REGEX, idCard)) {
			//校验地区码和Date是否合法
			if( isValidAreaCode(idCard)
					&& isValidDateOfBirth(idCard)
					&&isValid18Bit(idCard)){
				return true;
				}
		}
		return false;
	}
	
	/**
	 * 获取身份证最后一位校验位的算法为:
	 * (1)十七位数字本体码加权求和公式 (其中,第17位为表示男:奇数,女:偶数)
　　	 *     S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和 
　　      *     Ai:表示第i位置上的身份证号码数字值(0~9) 
　　      *     Wi:7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 （表示第i位置上的加权因子）
	 * (2)计算模 Y = mod(S, 11),Y=S mod 11
	 * (3)根据模，查找得到对应的校验码 
　　	 *		Y: 0 1 2 3 4 5 6 7 8 9 10 
　　	 *		校验码: 1 0 X 9 8 7 6 5 4 3 2
	 * @param idCard 输入需要校验的身份证号码(仅仅位18位长度的时候)
	 * @return 最后一位校验位
	 */
	public static boolean isValid18Bit(String idCard){
		int length = idCard!=null?idCard.length():0;//获得输入身份证号码长度
		if(length==18){//18位
			char[] temp = idCard.substring(0, 17).toCharArray();//存放每一位字符串的字符数组
			//(1)计算十七位数字本体码加权求和
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				sum += (temp[i]-'0')*WEIGHT[i];
			}
			//(2)计算模 Y = mod(S, 11),Y=S mod 11
			int modResult = sum%11;
			//(3)根据模，查找得到对应的校验码 
			return modResult == 2?'X' == idCard.charAt(idCard.length()-1)||'x' == idCard.charAt(idCard.length()-1):VALIDATE[modResult] == idCard.charAt(idCard.length()-1);
		}else if(length==15) {
			return true;
		}
		return false;
	}
	
	/**
	 * 15位身份证转成18位
	 * @param idCard 15位长度的身份证号码
	 * @return 对应的18位身份证号码的最后一位合法位
	 */
/*	private static char change15To18IDCard(String idCard){
		String temp = idCard;
		if(idCard.length()==15){//15位(可以算出它对应的18位身份证号码)  年份补19--世纪  例如62--1962,最后一位任意补一个字符
			temp = idCard.substring(0, 6)+"19"+idCard.substring(6,15)+"X";
		}
		//得到15位身份证转化后的最后一位合法位
		char lastBit = getIDCard18LastBit(temp);
		
		return lastBit;
	}*/
	
	/*public static void main(String[] args) {
		*//**18位的测试*//*
		String idCard = "52242619811105565x";
		boolean result = isValidIDCard(idCard);
		System.out.println(result);
		*//**15位测试*//*
		String idCard15 = "431023520516182";
		boolean res15=  isValidNumber15(idCard15);
		System.out.println(res15);
	}*/
}
