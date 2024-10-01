package com.ndanh.learn.spring.kafka.producer.service;

import com.ndanh.learn.spring.kafka.producer.record.Product;

public interface ProducerService {
    void sendMessage(Product message);
}
