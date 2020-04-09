package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 李聪
 * @date 2020/2/18 9:11
 */

@Component
@RabbitListener(queues = "itcast")
public class Customer1 {

   /* @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("333直接模式消费消息:" + msg);
    }*/
    @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("itcast: " + msg);
    }
}
