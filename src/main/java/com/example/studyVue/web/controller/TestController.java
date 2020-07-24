package com.example.studyVue.web.controller;

import com.example.studyVue.web.dao.TestDao;
import com.example.studyVue.web.util.ResultInfo;
import com.example.studyVue.web.websocketServer.WebsocketServer;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author: z6~
 * @time: 2019-10-12 15:28
 */
@RequestMapping("/test")
@RestController
public class TestController implements RabbitTemplate.ReturnCallback {

    @Autowired
    private TestDao testDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Channel channel;

    private ReentrantLock reentrantLock = new ReentrantLock();

    @GetMapping("/test")
    public String gettest() {
        redisTemplate.opsForValue().set("1", "1", 10, TimeUnit.SECONDS);
        String a = (String) redisTemplate.opsForValue().get("1");
        return a;
    }

    @GetMapping("/sendrb")
    public ResultInfo sendRabbitMessage(String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mea(name);
            }
        }).start();
        System.out.println(Thread.activeCount());
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("发送到第snflanlasn个");
        return ResultInfo.success();

    }

    public synchronized void mea(String name) {
        Map<String, Object> res = new HashMap<>();
        res.put("name", name);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback((correlationData, ack, course) -> {
            System.out.println(course);
            System.out.println(correlationData);
            if (!ack) {
                System.out.println("消息发送失败");
            } else {
                System.out.println("消息发送成功");
            }
        });
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", name);
//        rabbitTemplate.convertAndSend("helloExchange", "hello", res);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("send success" + message.toString() + "====" + i + "=====" + s1 + "=====" + s2);
    }
}
