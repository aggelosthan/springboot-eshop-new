package com.angelos.e_shop.app.services;

import com.angelos.e_shop.app.domain.Order;
import com.angelos.e_shop.app.exception.OrderNotFound;
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
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new OrderNotFound("Order with ID " + id + " not found.");
        }
        return order;
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
