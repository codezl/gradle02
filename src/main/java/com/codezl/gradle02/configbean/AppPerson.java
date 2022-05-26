package com.codezl.gradle02.configbean;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/19/17:37
 * @Description:
 */
public class AppPerson {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "AppPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
}
