package kr.nzzi.msa.mqtest2.event.sender;

import kr.nzzi.msa.mqtest2.event.ProductEvent;
import kr.nzzi.msa.mqtest2.rabbidmq.RabbitMqEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductSender implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public ProductSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        ProductEvent event = ProductEvent.builder()
                .name("초코파이")
                .price(3600)
                .build();

        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitMqEvent.PRODUCT_MESSAGE_EVENT, "all message!!");

        System.out.println("Sending my custom message");
        rabbitTemplate.convertAndSend(RabbitMqEvent.PRODUCT_SAVE_EVENT, event);
    }
}