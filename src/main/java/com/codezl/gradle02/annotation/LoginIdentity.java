package com.codezl.gradle02.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/16/16:17
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface LoginIdentity {

    String value() default "";
}
