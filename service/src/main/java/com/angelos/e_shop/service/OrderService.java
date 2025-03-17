package com.angelos.e_shop.service;

import com.angelos.e_shop.domain.Order;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    List<Order> getOrdersByCustomerId(Long customerId);
    List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> getOrdersWithAmountGreaterThan(double amount);
    List<Order> getOrdersByCustomerEmail(String email);
    List<Order> getOrdersContainingProduct(Long productId);
    List<Order> getOrdersWithAmountInRange(double minAmount, double maxAmount);
} 