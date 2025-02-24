package com.angelos.e_shop.app.repository.order;

import com.angelos.e_shop.app.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    List<OrderRepository> findAll();

    Order findById(Long id);

    void save(Order order);
}
