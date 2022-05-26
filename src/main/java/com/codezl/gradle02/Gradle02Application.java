package com.codezl.gradle02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.codezl")
public class Gradle02Application {

    public static void main(String[] args) {
        SpringApplication.run(Gradle02Application.class, args);
    }

}
