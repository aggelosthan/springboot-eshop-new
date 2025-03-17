package com.angelos.e_shop.common.exception;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(Long id) {
        super("Order not found with id: " + id);
    }
} 