package com.angelos.e_shop.service.impl;

import com.angelos.e_shop.common.exception.CustomerNotFound;
import com.angelos.e_shop.domain.Customer;
import com.angelos.e_shop.repository.CustomerRepository;
import com.angelos.e_shop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFound(id);
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFound(id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFound("Customer not found with email: " + email));
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Customer> findCustomersWithOrdersAboveAmount(double amount) {
        return customerRepository.findCustomersWithOrdersAboveAmount(amount);
    }

    @Override
    public List<Customer> findCustomersWithOrdersInDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return customerRepository.findCustomersWithOrdersInDateRange(startDate, endDate);
    }
} 