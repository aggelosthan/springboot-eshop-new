package com.angelos.e_shop.app.repository.product;

import com.angelos.e_shop.app.domain.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Product product);
    void deleteById(Long id);
    List<Product> findByName(String name);


}
