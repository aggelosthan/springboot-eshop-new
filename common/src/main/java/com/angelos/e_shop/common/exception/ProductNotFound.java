package com.angelos.e_shop.common.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(Long id) {
        super("Product not found with id: " + id);
    }
} 