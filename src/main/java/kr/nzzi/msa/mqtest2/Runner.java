package kr.nzzi.msa.mqtest2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private static final String topicExchange = "my-exchange";

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        Product product = Product.builder()
                .name("초코파이")
                .price(3600)
                .build();

        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(topicExchange, "product.message", "all message!!");

        System.out.println("Sending my custom message");
        rabbitTemplate.convertAndSend(topicExchange, "product.save", product);
    }
}