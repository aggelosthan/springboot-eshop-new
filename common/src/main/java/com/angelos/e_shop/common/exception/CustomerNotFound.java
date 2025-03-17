package com.angelos.e_shop.common.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(Long id) {
        super("Customer not found with id: " + id);
    }
} 