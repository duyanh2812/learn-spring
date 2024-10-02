package com.ndanh.learn.spring.rabbitmq.consumer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SynchronousMessageConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "requestQueue")
    public void receiveMessage(Message requestMessage) {
        String request = new String(requestMessage.getBody());
        String response = "Processed: " + request;

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setCorrelationId(requestMessage.getMessageProperties().getCorrelationId());
        Message responseMessage = new Message(response.getBytes(), messageProperties);

        rabbitTemplate.send(requestMessage.getMessageProperties().getReplyTo(), responseMessage);
    }
}