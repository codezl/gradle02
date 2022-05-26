package com.codezl.gradle02.config;

import com.codezl.gradle02.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/18/17:12
 * @Description:
 */
@Configuration
public class loginInterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**","**")
                .excludePathPatterns("/login/**");
    }
}
