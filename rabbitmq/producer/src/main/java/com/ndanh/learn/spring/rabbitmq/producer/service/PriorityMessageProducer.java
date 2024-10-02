package com.ndanh.learn.spring.rabbitmq.producer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String routingKey, String message, int priority) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setPriority(priority);
        Message msg = new Message(message.getBytes(), messageProperties);
        rabbitTemplate.send("priorityExchange", routingKey, msg);
    }
}