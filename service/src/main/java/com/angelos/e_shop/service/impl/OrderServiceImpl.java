package com.angelos.e_shop.service.impl;

import com.angelos.e_shop.common.exception.OrderNotFound;
import com.angelos.e_shop.domain.Order;
import com.angelos.e_shop.repository.OrderRepository;
import com.angelos.e_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFound(id));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFound(id);
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFound(id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<Order> getOrdersWithAmountGreaterThan(double amount) {
        return orderRepository.findOrdersWithAmountGreaterThan(amount);
    }

    @Override
    public List<Order> getOrdersByCustomerEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }

    @Override
    public List<Order> getOrdersContainingProduct(Long productId) {
        return orderRepository.findOrdersContainingProduct(productId);
    }

    @Override
    public List<Order> getOrdersWithAmountInRange(double minAmount, double maxAmount) {
        return orderRepository.findOrdersWithAmountInRange(minAmount, maxAmount);
    }
} 