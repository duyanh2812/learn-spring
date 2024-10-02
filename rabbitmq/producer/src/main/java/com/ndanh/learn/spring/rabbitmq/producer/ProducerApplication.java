package com.ndanh.learn.spring.rabbitmq.producer;

import com.ndanh.learn.spring.rabbitmq.producer.service.DirectMessageProducer;
import com.ndanh.learn.spring.rabbitmq.producer.service.FanoutMessageProducer;
import com.ndanh.learn.spring.rabbitmq.producer.service.SynchronousMessageProducer;
import com.ndanh.learn.spring.rabbitmq.producer.service.TopicMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}


@Component
class CommandLineAppRunner implements CommandLineRunner {

	@Autowired
	private DirectMessageProducer directMessageProducer;
	@Autowired
	private FanoutMessageProducer fanoutMessageProducer;
	@Autowired
	private TopicMessageProducer topicMessageProducer;

	@Autowired
	private SynchronousMessageProducer synchronousMessageProducer;
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Please provide two input parameters:");

			String exchangeType = scanner.nextLine();
			String routingKey = scanner.nextLine();
			String message = scanner.nextLine();

			processRequest(exchangeType, routingKey, message);
		}
	}

	private void processRequest(String exchangeType, String routingKey, String message) {
		switch (exchangeType) {
			case "direct":
				directMessageProducer.sendMessage(routingKey, message);
				break;
			case "fanout":
				fanoutMessageProducer.sendMessage(routingKey, message);
				break;
			case "topic":
				topicMessageProducer.sendMessage(routingKey, message);
				break;
			case "sync":
				System.out.println(synchronousMessageProducer.sendAndReceive(message));
				break;
			default:
				System.out.println("Invalid input parameters");
		}
	}
}