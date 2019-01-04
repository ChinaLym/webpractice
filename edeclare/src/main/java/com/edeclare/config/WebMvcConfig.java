package com.edeclare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.edeclare.aop.interceptor.LoginRequiredInterceptor;
/**
* Type: WebMvcConfig
* Description: MVC相关配置
* 	所有与本项目相关的文件，请置于 D:/eDeclare/ 下
* 		日志文件：D:/eDeclare/log/
* 		文件上传：D:/eDeclare/upload/
* @author LYM
* @date Dec 16, 2018
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//配置LoginRequired，可以被SpringMVC识别
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginRequiredInterceptor()) 
                .addPathPatterns("/**"); 
    }
	
    // 保存上传文件的目录
    public final static String FILE_DIR = "D:/eDeclare/upload/";
    
    //虚拟路径
    public final static String VIRTUL_DIR = "/upload/";
    
    //虚拟拦截路径
    public final static String VIRTUL_DIR_Handle = "/upload/**";
    
    /**
     * 配置静态资源的web访问路径，例如上传的文件 abc.png 保存在 D:/book/upload 下
     * 那么在浏览器中访问的路径为：http://localhost:8080/upload/abc.png
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(VIRTUL_DIR_Handle).addResourceLocations(
                "file:///" + WebMvcConfig.FILE_DIR);
    }
    
}
