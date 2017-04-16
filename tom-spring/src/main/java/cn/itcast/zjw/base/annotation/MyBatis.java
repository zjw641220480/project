package cn.itcast.zjw.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;


/**
 *
 * <p>Title:MyBatis.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月16日上午11:15:38
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Component
public @interface MyBatis {
	String name() default "";
}
