//package com.example.studyVue.web.consumer;
//
//import com.example.studyVue.web.service.TestService;
//import com.rabbitmq.client.AMQP;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @author: z6~
// * @time: 2020-04-29 16:31
// */
//@Component
//@RabbitListener(queues = "hello1")
//public class ConsumerHello {
//    @Autowired
//    private TestService testService;
//
//    @RabbitHandler
//    void main(Map data, Channel channel, Message ms) {
//        System.out.println("自测通道收到消息");
//        System.out.println(data.get("name"));
//        try {
////            testService.insertName("hello管道数据");
//            channel.basicAck(ms.getMessageProperties().getDeliveryTag(), false);
//            System.out.println("消费成功，返回ack");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
