package com.codezl.gradle02.controller;

import com.codezl.gradle02.config.SpringConfig;
import com.codezl.gradle02.config.SpringConfig2;
import com.codezl.gradle02.config.SpringYmlConfig;
import com.codezl.gradle02.configbean.ConfigPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/19/16:56
 * @Description:
 */
@RestController
@RequestMapping("config")
public class SpringConfigController {

    @Autowired
    ConfigPerson person;
    @Autowired
    SpringConfig2 springConfig2;
    @Autowired
    SpringYmlConfig springYmlConfig;
    @GetMapping("person")
    public void person() {
        Consumer<Object> consumer = (object) -> {
            Class<?> aClass = object.getClass();
            String classN = object.getClass().getName();
            String classV = object.toString();
            System.out.print(aClass+">N>"+classN+">V>"+classV+"\n");
        };
        consumer.accept(person);
        consumer.accept(springConfig2.getPerson2());
        consumer.accept(springYmlConfig.getDogs());
    }
}
