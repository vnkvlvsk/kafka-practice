package org.example.producer;

import org.example.Order;

public interface OrderProducer {
    void sendOrder(Order order);
}
