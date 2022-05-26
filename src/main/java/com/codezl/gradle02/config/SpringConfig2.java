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
 * @Date: 2022/04/19/18:39
 * @Description:
 */
@Configuration
@PropertySource(value = {"classpath:/person.properties"})
public class SpringConfig2 {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public AppPerson getPerson2() {
        return new AppPerson();
    }
}
