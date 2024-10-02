package com.ndanh.learn.spring.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DirectMessageConsumer {

    @RabbitListener(queues = "directQueue1")
    public void receiveMessage(String message) {
        System.out.println("Received message from Direct Exchange 1: " + message);
    }

    @RabbitListener(queues = "directQueue2")
    public void receiveMessage2(String message) {
        System.out.println("Received message from Direct Exchange 2: " + message);
    }
}