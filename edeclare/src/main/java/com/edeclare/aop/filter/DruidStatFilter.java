package com.edeclare.aop.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
 
import com.alibaba.druid.support.http.WebStatFilter;
/**
* Type: DruidStatFilter
* Description: 记录请求，监控数据库访问性能,有利于分析优化sql和解决慢查询
* 	监控地址：http://localhost:8080/druid/
* Refer: https://github.com/alibaba/druid
* @author LYM
* @date Dec 16, 2018
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
    	//忽略资源（不记录静态资源的请求，不记录控制面板的请求）
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
   }
)
public class DruidStatFilter extends WebStatFilter {

}

