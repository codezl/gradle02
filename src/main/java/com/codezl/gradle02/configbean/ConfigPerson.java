package com.codezl.gradle02.configbean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/19/16:53
 * @Description:
 */
// 必须有@Configuration注解@PropertySource才能生效



/**
 * 需要get和set方法，但不能使用@Data注解生成
 */
@Configuration
@PropertySource({"classpath:/person.properties"})
@ConfigurationProperties(prefix = "person")
@Component
public class ConfigPerson {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ConfigPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
