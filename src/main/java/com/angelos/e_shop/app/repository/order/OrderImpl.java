package com.angelos.e_shop.app.repository.order;

import com.angelos.e_shop.app.domain.Order;
import com.angelos.e_shop.app.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderImpl {

    private final List<OrderRepository> orderRepositories = new ArrayList<>();

    public List<OrderRepository> findAll() {
        return orderRepositories;
    }


    public void save(Order order) {
        if (order.getId() == null) {
            order.setId((long) (orderRepositories.size() + 1));
        }
        orderRepositories.add((OrderRepository) order);
    }
}
