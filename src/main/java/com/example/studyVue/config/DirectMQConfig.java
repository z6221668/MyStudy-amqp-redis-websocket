package com.example.studyVue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: z6~
 * @time: 2020-04-29 16:27
 */
@Configuration
public class DirectMQConfig {

    @Bean
    public Queue testQueue1() {
        //设置队列的初始化参数
//        Map<String, Object> map = new HashMap<String, Object>();
//        //指定消息队列的长度
//        map.put("x-max-length", 100);
//
//        //当队列满时，多余的消息直接拒绝接收，多余的消息被丢弃
//        map.put("x-overflow", "reject-publish");
        return new Queue("hello1", true);
    }

    @Bean
    public Queue testQueue2() {
        return new Queue("hello2", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("helloExchange", false, true);
    }

    @Bean
    Binding bindDirect() {
        return BindingBuilder.bind(testQueue1()).to(directExchange()).with("hello");
    }
}
