package org.example.producer.impl;

import org.example.Order;
import org.example.TopicName;
import org.example.producer.OrderProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducerImpl implements OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducerImpl(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send(TopicName.ORDERS_TOPIC, order);
    }
}
