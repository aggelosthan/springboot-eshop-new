package com.angelos.e_shop.app.controllers;

import com.angelos.e_shop.app.domain.Order;
import com.angelos.e_shop.app.repository.order.OrderRepository;
import com.angelos.e_shop.app.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // retrieve all orders
    @GetMapping
    public List<OrderRepository> getAllOrders() {
        return orderService.getAllOrders();
    }

    // retrieve an order by its ID
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // create a new order
    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }
}
