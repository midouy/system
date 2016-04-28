package org.system.web.annotation.aspect;
import java.lang.annotation.*;
/**
 * Created by wangyanming on 2016/4/28.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface SystemServiceLog {

	String description()  default "";

}