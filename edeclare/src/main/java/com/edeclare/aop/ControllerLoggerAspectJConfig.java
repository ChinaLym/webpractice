package com.edeclare.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* Type: ControllerLoggerAspectJConfig
* Description: 
* com.edeclare.controller中所有以Controller结尾的类中的所有public方法
* 或者添加@ControllerLogger注解的方法，都会前后记录日志及异常
* @author LYM
* @date Dec 16, 2018
 */
@Aspect
@Component("ControllerLoggerAspectJConfig")
public class ControllerLoggerAspectJConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLoggerAspectJConfig.class);

    //定义一个切点,代表service下所有public方法且有xxxMapping注解或者添加@ControllerLogger注解的方法，都会前后记录日志及异常
    @Pointcut("execution(public * com.edeclare.controller.*Controller.*(..)) " +
            "&& @annotation(com.edeclare.annotation.ControllerLogger)" + 
    		"|| @annotation(org.springframework.web.bind.annotation.GetMapping)" + 
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" + 
            "|| @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void log() {}

    /**
     * Title: beforeControllerLogger
     * Description: 进入方法前要做的事情：记录方法名和入参
     * @param joinPoint
     */
    @Before("log()")
    public void beforeControllerLogger(JoinPoint joinPoint) {
    	Object[] args = joinPoint.getArgs();    	
    	StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--entry args : ");
	    sb.append(Arrays.toString(args));
	    LOGGER.info(sb.toString());
    }

    /**
     * Title: afterControllerLogger
     * Description:  切点所在函数正常返回之后要做的事情：记录方法名和返回值
     * @param joinPoint 切入点
     * @param returnObject	返回值（返回的数据）
     */
    @AfterReturning(value = "log()", returning = "returnObject")
    public void afterControllerLogger(JoinPoint joinPoint, Object returnObject) {
    	StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--return object : ");
	    if (returnObject == null) {
	    	sb.append("null.");
		}else {
			sb.append(returnObject.toString());
		}
	    LOGGER.info(sb.toString());
    }
    
    /**
     * Title: handlerExcetionLog
     * Description: 出现异常要做的事情：记录方法名，异常类型和描述
     * @param joinPoint	切点
     * @param exception	异常
     */
    @AfterThrowing(value = "log()", throwing = "exception")
	private void handlerExcetionLog(JoinPoint joinPoint, Exception exception) {
		// 获得类名和方法名称
	    StringBuilder sb = new StringBuilder(joinPoint.getSignature().toShortString());
	    sb.append("--exception! : ");
	    sb.append(exception.getClass());
	    sb.append(" : ");
	    sb.append(exception.getMessage());
	    LOGGER.info(sb.toString());
    }
}