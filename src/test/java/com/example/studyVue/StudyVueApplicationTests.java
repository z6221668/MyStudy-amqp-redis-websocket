package com.example.studyVue;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyVueApplicationTests {

    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        System.out.println("发送消息");
        for (int a=0;a<50;a++){
//            rabbitTemplate.convertAndSend("hello1","group2", "第"+a+"次发送信息");
        }


    }

}
