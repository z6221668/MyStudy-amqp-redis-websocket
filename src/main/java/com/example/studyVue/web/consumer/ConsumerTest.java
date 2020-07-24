//package com.example.studyVue.web.consumer;
//
//import com.example.studyVue.web.entity.po.UserPO;
//import com.example.studyVue.web.exception.RException;
//import com.example.studyVue.web.service.TestService;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * @author: z6~
// * @time: 2020-04-29 16:14
// */
//@Component
//@RabbitListener(queues = "TestDirectQueue")
//public class ConsumerTest {
//
//    @Autowired
//    private TestService testService;
//
//
//    @RabbitHandler
//    public void handle(String name, Channel channel, Message ms) {
//        System.out.println("一般消息");
//        System.out.println("收到消息：" + name);
//        try {
////            testService.insertName("test管道数据");
//            UserPO userPO = null;
////            int a=userPO.getId();
//            System.out.println(ms.getMessageProperties());
//            System.out.println(channel);
//            channel.basicAck(ms.getMessageProperties().getDeliveryTag(), false);
//        } catch (IOException e) {
//            throw new RException("123123");
//        }
//        System.out.println("消费成功，返回ack");
//    }
//}
