package org.system.web.annotation.aspect;

import java.lang.annotation.*;

/**
 * Created by wangyanming on 2016/4/28.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface SystemControllerLog {

	String description()  default "";
}

/**
 *  AOP 使用教程参考
 *  http://blog.csdn.net/czmchen/article/details/42392985
 *  http://blog.csdn.net/wangpeng047/article/details/8556800
 */
