package org.example.service.impl;

import org.example.Order;
import org.example.dto.OrderRequest;
import org.example.dto.OrderResponse;
import org.example.producer.OrderProducer;
import org.example.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderProducer orderProducer;

    public OrderServiceImpl(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order(
                UUID.randomUUID(),
                request.deliveryAddress(),
                request.name(),
                request.phone(),
                request.products(),
                LocalDateTime.now()
        );

        orderProducer.sendOrder(order);

        OrderResponse response = new OrderResponse(
                order.orderId(),
                order.deliveryAddress(),
                order.name(),
                order.phone(),
                order.products(),
                order.createdAt()
        );
        return response;
    }
}
