package com.codezl.gradle02.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author toutou
 * 监听服务器上的kafka是否有相关的消息发过来
 * @date by 2019/08
 */
@Component
public class KafkaConsumerDemo {
    /**
     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
     */
    @KafkaListener(topics = "demo")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

    @KafkaListener(topics = "test")
    public void listen2 (ConsumerRecord<?,?> record) {
        System.out.printf("topics is %s,offset is %d, value is %s\n",record.topic(), record.offset(),record.value());
    }

    @KafkaListener(topicPattern = "\\*+ \\*")
    public void listen3 (ConsumerRecord<?,?> record) {
        System.out.printf("监听列表 %s,offset is %d, value is %s\n",record.topic(), record.offset(),record.value());
    }
}