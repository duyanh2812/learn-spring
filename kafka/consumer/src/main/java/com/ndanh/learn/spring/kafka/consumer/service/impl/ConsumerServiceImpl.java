package com.ndanh.learn.spring.kafka.consumer.service.impl;

import com.ndanh.learn.spring.kafka.producer.record.Product;
import com.ndanh.learn.spring.kafka.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public void consumeMessage(Product message) {
        System.out.println("Consumed message: " + message.description());
    }
}
