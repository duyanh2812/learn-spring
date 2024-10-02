package com.ndanh.learn.spring.rabbitmq.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class RabbitMQConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setChannelTransacted(true); // Enable transactions
        return rabbitTemplate;
    }
    @Bean
    public Queue directQueue1(){
        return new Queue("directQueue1", true);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("directQueue2", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding directBinding1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("directKey");
    }

    @Bean
    public Binding directBinding2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("directKey");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topicQueue1", true);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topicQueue2", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding topicBinding1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("topic.key.#");
    }

    @Bean
    public Binding topicBinding2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("topic.key.specific");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1", true);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2", true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    public Queue priorityQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 10); // Set the maximum priority
        return new Queue("priorityQueue", true, false, false, args);
    }

    @Bean
    public DirectExchange priorityExchange() {
        return new DirectExchange("priorityExchange");
    }

    @Bean
    public Binding priorityBinding(Queue priorityQueue, DirectExchange priorityExchange) {
        return BindingBuilder.bind(priorityQueue).to(priorityExchange).with("priorityKey");
    }

    @Bean
    public Queue requestQueue() {
        return new Queue("requestQueue", true);
    }

    @Bean
    public Queue replyQueue() {
        return new Queue("replyQueue", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("directExchange2");
    }

    @Bean
    public Binding requestBinding(Queue requestQueue, DirectExchange exchange) {
        return BindingBuilder.bind(requestQueue).to(exchange).with("requestKey");
    }

    @Bean
    public Binding replyBinding(Queue replyQueue, DirectExchange exchange) {
        return BindingBuilder.bind(replyQueue).to(exchange).with("replyKey");
    }

}
