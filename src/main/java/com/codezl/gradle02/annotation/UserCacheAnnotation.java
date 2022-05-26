package com.codezl.gradle02.annotation;

import org.springframework.cache.annotation.Cacheable;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/16/14:53
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Cacheable(value = "user")
public @interface UserCacheAnnotation {
}
