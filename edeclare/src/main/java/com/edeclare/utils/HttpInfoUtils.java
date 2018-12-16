package com.edeclare.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInfoUtils {
	
	
	//******处理请求头
	
	public static Map<String, String> getHeadersInfo(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		
		Enumeration<String> headerNames = request.getHeaderNames();
		String key = null;
		String value = null;
		while(headerNames.hasMoreElements()) {
			key = (String) headerNames.nextElement();
			value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
	public static String getIpAddr(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	}   
	
	
	/*
     * unicode编码转中文
     */
    public static String decodeUnicode(final String dataStr) {
    	if(dataStr ==null)return null;
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
    
    //***生成验证码*********************
    
    private static final int ImageWidth = 120;
	private static final int Imageheight = 50;
	
	static final String[] Fonts = {"方正舒体","华文彩云","华文琥珀","华文新魏","幼圆",
			"微软雅黑","楷体","Agency FB","Bradley Hand ITC","Copperplate Gothic Light"};
	static final String[] chars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
			"J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    public static void createNewVerifyImage(HttpServletRequest request, HttpServletResponse response) {
		//没有I、O
		// 设置响应的类型
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(ImageWidth, Imageheight, BufferedImage.TYPE_INT_RGB);
		// 获得一个画笔
		Random ran = new Random();
		Color[] color = get3RandColor();
		Graphics graphics = image.getGraphics();
/*		graphics.setColor(new Color(255, 255, 255));
		graphics.fillRect(0, 0, ImageWidth, Imageheight);*/
		
		graphics.setColor(color[0]);// 设置画笔的颜色
		// 画一个长方形
		graphics.fillRoundRect(0, 0, ImageWidth, Imageheight, 10, 10);
		
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int index = ran.nextInt(chars.length);
			sbf.append(chars[index]);
		}
		request.getSession().setAttribute("imageValue", sbf.toString().toLowerCase());
		request.getSession().setAttribute("checkResult", false);
		// 重新设置画笔的颜色
		graphics.setColor(color[1]);
		for (int i = 0; i < 4; i++){
			graphics.setFont(new Font(getRandFonts(ran.nextInt(10)), ran.nextInt(3), 30+ran.nextInt(10)));
			graphics.drawString(sbf.charAt(i)+"", i*30+5, 30+ran.nextInt(15));
		}
		//addSalt
		graphics.setFont(new Font("微软雅黑",Font.PLAIN,20));
		graphics.setColor(color[2]);
		for (int i = 0; i < 8; i++){
			graphics.drawString(".", i*15+ran.nextInt(10), 15+ran.nextInt(40));
			graphics.drawString(".", i*15+ran.nextInt(10), 15+ran.nextInt(40));
			graphics.drawString(".", i*15+ran.nextInt(10), 15+ran.nextInt(40));
		}
		// 将图片输出 
		OutputStream out;
		try {
			out = response.getOutputStream();
			ImageIO.write(image, "jpeg", out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

	public static Color[] get3RandColor() {
		Color[] c = new Color[3];
		Random ran = new Random();
		if(ran.nextInt(2)==1) {
			c[0] = new Color(120 + ran.nextInt(50), 120 + ran.nextInt(50), 120 + ran.nextInt(50));
			c[1] = new Color(20+ran.nextInt(80),20+ran.nextInt(80),20+ran.nextInt(80));
			c[2] = new Color(120 + ran.nextInt(120), 12 + ran.nextInt(50), 120 + ran.nextInt(120));
		}else {
			c[1] = new Color(150 + ran.nextInt(80), 150 + ran.nextInt(80), 150 + ran.nextInt(80));
			c[0] = new Color(20+ran.nextInt(80),20+ran.nextInt(80),10+ran.nextInt(80));
			c[2] = new Color(ran.nextInt(100),ran.nextInt(100),ran.nextInt(100));
		}
		
		
		return c;
	}
	
	public static String getRandFonts(int index) {
		return Fonts[index];
	}
	/*void getFonts(){
		    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    String[] fontNames = e.getAvailableFontFamilyNames();
		    for (String fontName : fontNames) {
		        System.out.println(fontName);
		    }

	}*/
}
