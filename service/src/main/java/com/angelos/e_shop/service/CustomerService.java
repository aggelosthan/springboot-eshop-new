package com.angelos.e_shop.service;

import com.angelos.e_shop.domain.Customer;
import java.time.LocalDateTime;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
    Customer getCustomerByEmail(String email);
    List<Customer> findCustomersByName(String name);
    List<Customer> findCustomersWithOrdersAboveAmount(double amount);
    List<Customer> findCustomersWithOrdersInDateRange(LocalDateTime startDate, LocalDateTime endDate);
} 