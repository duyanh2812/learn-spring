package com.ndanh.learn.spring.kafka.producer;

import com.ndanh.learn.spring.kafka.producer.record.Product;
import com.ndanh.learn.spring.kafka.producer.service.ProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineAppRunner implements CommandLineRunner {
    private final ProducerService producerService;

    public CommandLineAppRunner(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            producerService.sendMessage(new Product(input, "test", 1));
            System.out.println("Enter input: ");
        }

    }
}
