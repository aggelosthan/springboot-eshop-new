package com.angelos.e_shop.app.repository.customer;

import com.angelos.e_shop.app.domain.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void update(Customer customer);
    void deleteById(Long id);
}
