package com.codezl.gradle02.annotation;

import javax.xml.bind.Element;
import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/29/15:27
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CommonResException {

    String msg() default "";

}
