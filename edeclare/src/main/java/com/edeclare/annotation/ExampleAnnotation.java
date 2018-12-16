package com.edeclare.annotation;

/*import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;*/

/**
* Type: ExampleAnnotation
* Description: 这是一个示例，请勿使用该注解！
* 若添加其他自定义注解，请放入本包下对应包中，包名以功能命名。
* 	
* 	如注解所在方法需要：
* 		前后记录日志				已实现√
		请求该方法前需要登录		已实现√
		该记录需要放入redis缓存	暂不考虑
		...
* @author LYM
* @date Dec 16, 2018
 */
/*@Target({ElementType.METHOD, ElementType.TYPE}) 
@Retention(RetentionPolicy.RUNTIME) */
public @interface ExampleAnnotation{


}
