package com.angelos.e_shop.app.repository.product;

import com.angelos.e_shop.app.domain.Product;
import com.angelos.e_shop.app.repository.order.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> productRepositories = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productRepositories;
    }

    @Override
    public Product findById(Long id) {
        return productRepositories.stream()
                .filter(order -> order.getId() != null && order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Product product) {

    }
}
