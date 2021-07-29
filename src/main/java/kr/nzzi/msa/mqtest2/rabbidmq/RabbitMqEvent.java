package kr.nzzi.msa.mqtest2.rabbidmq;

public interface RabbitMqEvent {
    String PRODUCT_EXCHANGE = "product.exchange";

    /* 브로드캐스트 */
    String PRODUCT_ALL_BROADCAST_EVENT = "product.#";
    String PRODUCT_MESSAGE_BROADCAST_EVENT = "product.message.*";
    String PRODUCT_SAVE_BROADCAST_EVENT = "product.save.*";

    /* 특정 타겟 전송 */
    String PRODUCT_MESSAGE_MONOLITHSERVER_EVENT = "product.message.monolithserver";
    String PRODUCT_SAVE_MONOLITHSERVER_EVENT = "product.save.monolithserver";

    String PRODUCT_MESSAGE_MQTEST1_EVENT = "product.message.mqtest1";
    String PRODUCT_SAVE_MQTEST1_EVENT = "product.save.mqtest1";
}
