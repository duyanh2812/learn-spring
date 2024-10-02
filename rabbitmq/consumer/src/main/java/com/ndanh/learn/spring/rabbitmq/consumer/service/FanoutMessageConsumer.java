package com.ndanh.learn.spring.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutMessageConsumer {

    @RabbitListener(queues = "fanoutQueue1")
    public void receiveMessage1(String message) {
        System.out.println("Received message from Fanout Exchange 1: " + message);
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void receiveMessage2(String message) {
        System.out.println("Received message from Fanout Exchange 2: " + message);
    }
}