package com.ndanh.learn.spring.rabbitmq.producer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanoutMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String routingKey, String message) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        Message amqpMessage = new Message(message.getBytes(), messageProperties);
        rabbitTemplate.send("fanoutExchange", routingKey, amqpMessage);
    }
}