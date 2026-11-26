package org.example.service.impl;

import org.example.Order;
import org.example.dto.DeliveryOrder;
import org.example.dto.DeliveryStatus;
import org.example.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public DeliveryOrder process(Order order) {
        DeliveryOrder deliveryOrder = new DeliveryOrder(
                order.orderId(),
                order.deliveryAddress(),
                order.name(),
                order.phone(),
                order.products(),
                order.createdAt(),
                DeliveryStatus.ACCEPTED,
                LocalDateTime.now().plusHours(1)
        );

        return deliveryOrder;
    }
}
