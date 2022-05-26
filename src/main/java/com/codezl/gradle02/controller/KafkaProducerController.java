package com.codezl.gradle02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toutou
 * @date by 2019/08
 */
@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("message/send")
    public String send(String msg){
        kafkaTemplate.send("demo", msg); //使用kafka模板发送信息
        return "success";
    }

    @GetMapping("msg/send2")
    public String endMsg() {
        kafkaTemplate.send("test","hello kafka!");
        return "success";
    }
}