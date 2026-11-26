package org.example.dto;

import org.example.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record DeliveryOrder(
        UUID orderId,
        String deliveryAddress,
        String name,
        String phone,
        List<Product> products,
        LocalDateTime createdAt,
        DeliveryStatus deliveryStatus,
        LocalDateTime estimatedDeliveryTime
) {
}
