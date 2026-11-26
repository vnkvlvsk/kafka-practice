package org.example.service;

import org.example.Order;
import org.example.dto.DeliveryOrder;

public interface DeliveryService {
    DeliveryOrder process(Order order);
}
