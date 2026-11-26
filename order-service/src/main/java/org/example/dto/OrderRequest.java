package org.example.dto;

import org.example.Product;

import java.util.List;

public record OrderRequest(
        String deliveryAddress,
        String name,
        String phone,
        List<Product> products
) {
}
