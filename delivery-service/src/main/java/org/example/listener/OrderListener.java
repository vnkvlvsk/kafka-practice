package org.example.listener;

import org.example.Order;
import org.example.TopicName;
import org.example.dto.DeliveryOrder;
import org.example.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private static final Logger log = LoggerFactory.getLogger(OrderListener.class);

    private final DeliveryService deliveryService;

    public OrderListener(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @KafkaListener(topics = { TopicName.ORDERS_TOPIC })
    public void listenOrder(Order order) {
        DeliveryOrder deliveryOrder = deliveryService.process(order);
        log.info("Получен заказ: {}", deliveryOrder);
    }
}
