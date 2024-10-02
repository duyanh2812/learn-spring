package com.ndanh.learn.spring.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PriorityMessageConsumer {

    @RabbitListener(queues = "priorityQueue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}