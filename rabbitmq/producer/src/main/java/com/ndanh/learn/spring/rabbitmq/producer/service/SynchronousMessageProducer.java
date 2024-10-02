package com.ndanh.learn.spring.rabbitmq.producer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SynchronousMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendAndReceive(String message) {
        String correlationId = UUID.randomUUID().toString();
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setCorrelationId(correlationId);
        messageProperties.setReplyTo("replyQueue");
        Message requestMessage = new Message(message.getBytes(), messageProperties);

        RabbitTemplate nonTransactionalTemplate = new RabbitTemplate(rabbitTemplate.getConnectionFactory());
        Message responseMessage = nonTransactionalTemplate.sendAndReceive("directExchange2", "requestKey", requestMessage);
        if (responseMessage != null) {
            return new String(responseMessage.getBody());
        } else {
            throw new RuntimeException("No response received");
        }
    }
}