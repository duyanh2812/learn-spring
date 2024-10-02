package com.ndanh.learn.spring.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageConsumer {

    @RabbitListener(queues = "topicQueue1")
    public void receiveMessage1(String message) {
        System.out.println("Received message from Topic Exchange 1: " + message);
    }

    @RabbitListener(queues = "topicQueue2")
    public void receiveMessage2(String message) {
        System.out.println("Received message from Topic Exchange 2: " + message);
    }
}