package com.ndanh.learn.spring.kafka.producer.service.impl;

import com.ndanh.learn.spring.kafka.producer.record.Product;
import com.ndanh.learn.spring.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<Object, Product> kafkaTemplate;

    public ProducerServiceImpl(KafkaTemplate<Object, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic}")
    String topic;
    @Override
    public void sendMessage(Product message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Message sent successfully");
    }
}
