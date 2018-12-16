package com.edeclare.servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
 
import com.alibaba.druid.support.http.StatViewServlet;
 /**
 * Type: DruidStatViewServlet
 * Description: DruidStatViewServlet
 * 	监控地址：http://localhost:8080/druid/
 * @author LYM
 * @date Dec 16, 2018
  */
@WebServlet(urlPatterns="/druid/*",
    initParams={
    	 /*
    	  * IP白名单(没有配置或者为空，则允许所有访问)，
    	  * 若添加白名单ip，请务必添加相应注释
    	  * ip1：服务器所在地址
    	  * ip2：lym_phone
    	  */
         @WebInitParam(name="allow",value="127.0.0.1,192.168.32.3"),
         // IP黑名单 (存在共同时，deny优先于allow，即黑名单优先)
         @WebInitParam(name="deny",value="192.168.1.73"),
         // 用户名
         @WebInitParam(name="loginUsername",value="admin"),
         // 密码
         @WebInitParam(name="loginPassword",value="admin"),
         // 禁用HTML页面上的“Reset All”功能
         @WebInitParam(name="resetEnable",value="false")
})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = -2688872071445249539L;
 
}
