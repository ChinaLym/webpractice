package com.edeclare.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
* Type: SpringUtil
* Description: 获取spring中的bean，方便调试和检测
* @author LYM
* @date Dec 16, 2018
 */
@Component
public class SpringUtil implements ApplicationContextAware {
	private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);
	private static ApplicationContext applicationContext;	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
		logger.info("ApplicationContext配置成功,applicationContext对象："+SpringUtil.applicationContext);
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	public static <T> T getBean(String name,Class<T> clazz) {
		return getApplicationContext().getBean(name,clazz);
	}
}