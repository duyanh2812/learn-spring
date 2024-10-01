package com.ndanh.learn.spring.kafka.consumer.listener;

import com.ndanh.learn.spring.kafka.producer.record.Product;
import com.ndanh.learn.spring.kafka.consumer.service.ConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
    private final ConsumerService consumerService;

    public KafkaConsumerListener(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(Product message) {
        consumerService.consumeMessage(message);
    }
}
