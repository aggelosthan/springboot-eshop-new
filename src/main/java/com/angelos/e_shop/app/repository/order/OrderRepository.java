package com.angelos.e_shop.app.repository.order;

import com.angelos.e_shop.app.domain.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findById(Long id);
    void save(Order order);
    void update(Order order);
    void deleteById(Long id);
}
