package kr.nzzi.msa.mqtest2.event.sender;

import kr.nzzi.msa.mqtest2.event.ProductEvent;
import kr.nzzi.msa.mqtest2.rabbidmq.RabbitMqEvent;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductSender implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {
        ProductEvent event = ProductEvent.builder()
                .name("초코파이")
                .price(3600)
                .build();

        /* 브로드캐스트 */
//        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_MESSAGE_BROADCAST_EVENT);
//        rabbitTemplate.convertAndSend(
//                RabbitMqEvent.PRODUCT_EXCHANGE,
//                RabbitMqEvent.PRODUCT_MESSAGE_BROADCAST_EVENT,
//                "all message!!");
//
//        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_SAVE_BROADCAST_EVENT);
//        rabbitTemplate.convertAndSend(
//                RabbitMqEvent.PRODUCT_EXCHANGE,
//                RabbitMqEvent.PRODUCT_SAVE_BROADCAST_EVENT,
//                event);

        /* 특정 타겟 전송 - monolith server */
        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_MESSAGE_MONOLITHSERVER_EVENT);
        rabbitTemplate.convertAndSend(
                RabbitMqEvent.PRODUCT_EXCHANGE,
                RabbitMqEvent.PRODUCT_MESSAGE_MONOLITHSERVER_EVENT,
                "to monolith");

        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_SAVE_MONOLITHSERVER_EVENT);
        rabbitTemplate.convertAndSend(
                RabbitMqEvent.PRODUCT_EXCHANGE,
                RabbitMqEvent.PRODUCT_SAVE_MONOLITHSERVER_EVENT,
                event);

        /* 특정 타겟 전송 - mqtest1 */
//        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_MESSAGE_MQTEST1_EVENT);
//        rabbitTemplate.convertAndSend(
//                RabbitMqEvent.PRODUCT_EXCHANGE,
//                RabbitMqEvent.PRODUCT_MESSAGE_MQTEST1_EVENT,
//                "to mqtest1");
//
//        System.out.println("Sending message..." + RabbitMqEvent.PRODUCT_SAVE_MQTEST1_EVENT);
//        rabbitTemplate.convertAndSend(
//                RabbitMqEvent.PRODUCT_EXCHANGE,
//                RabbitMqEvent.PRODUCT_SAVE_MQTEST1_EVENT,
//                event);
    }
}