package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Order(
        UUID orderId,
        String deliveryAddress,
        String name,
        String phone,
        List<Product> products,
        LocalDateTime createdAt
) {
}
