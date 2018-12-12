package com.edeclare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 保存上传文件的目录
    public final static String FILE_DIR = "D:/edclare/upload/";
    
    /**
     * 配置静态资源的web访问路径，例如上传的文件 abc.png 保存在 D:/book/upload 下
     * 那么在浏览器中访问的路径为：http://localhost:8080/upload/abc.png
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations(
                "file:///" + WebMvcConfig.FILE_DIR);
    }
}
