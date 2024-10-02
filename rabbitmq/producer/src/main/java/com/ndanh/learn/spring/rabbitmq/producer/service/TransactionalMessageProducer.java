package com.ndanh.learn.spring.rabbitmq.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public void sendMessage(String exchange, String routingKey, String message) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            // Additional operations can be added here
        } catch (Exception e) {
            // Transaction will be rolled back if an exception occurs
            throw e;
        }
    }
}