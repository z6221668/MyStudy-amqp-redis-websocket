//package com.example.studyVue.web.consumer;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author: z6~
// * @time: 2019-10-19 16:49
// */
//@Component
//@RabbitListener(queues = "hello")
//public class ConsumerA {
//
//    @RabbitHandler
//    public void getHello(String hello){
//        System.out.println("A通道"+hello);
//    }
//}
