package com.angelos.e_shop.app.repository.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final List<CustomerRepository> customerRepositories = new ArrayList<>();
    @Override
    public List<CustomerRepository> findAll() {
        return customerRepositories;
    }

//    @Override
//    public void save(Customer customer) {
//        // Optionally assign an ID if not set
//        if (customer.getId() == null) {
//            customer.setId((long) (customers.size() + 1));
//        }
//        customers.add(customer);
//    }
}
