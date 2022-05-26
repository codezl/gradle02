package com.codezl.gradle02.config;

import com.codezl.gradle02.configbean.Dog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/20/14:40
 * @Description:
 */
@Configuration
@PropertySource(value = {"classpath:/application.yml"})
public class SpringYmlConfig {
    @Bean
    @ConfigurationProperties(prefix = "am")
    public Dog getDogs() {
        return new Dog();
    }

}
