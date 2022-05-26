package com.codezl.gradle02.config;

import com.codezl.gradle02.configbean.AppPerson;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/19/17:35
 * @Description:
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public AppPerson getPerson() {
        return new AppPerson();
    }
}
