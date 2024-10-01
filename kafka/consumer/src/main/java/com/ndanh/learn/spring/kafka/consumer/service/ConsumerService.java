package com.ndanh.learn.spring.kafka.consumer.service;

import com.ndanh.learn.spring.kafka.producer.record.Product;

public interface ConsumerService {
    void consumeMessage(Product message);
}
