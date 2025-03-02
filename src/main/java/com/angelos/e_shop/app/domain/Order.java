package com.angelos.e_shop.app.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;



public class Order {
    private Long id;

    public Order(Customer customer, String message, List<Product> products, LocalDateTime orderDate, Address shippingAddress) {
        this.customer = customer;
        this.message = message;
        this.products = products;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
    }

    private Customer customer;

    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    private List<Product> products;

    private LocalDateTime orderDate = LocalDateTime.now();

    private Address shippingAddress;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", message='" + message + '\'' +
                ", products=" + products +
                ", orderDate=" + orderDate +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
