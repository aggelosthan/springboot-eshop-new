package com.angelos.e_shop.app.services;

import com.angelos.e_shop.app.domain.Order;
import com.angelos.e_shop.app.repository.order.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // dependency injection
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
    public void updateOrder(Order order) {
        orderRepository.update(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
