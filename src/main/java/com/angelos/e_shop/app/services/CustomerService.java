package com.angelos.e_shop.app.services;

import com.angelos.e_shop.app.domain.Customer;
import com.angelos.e_shop.app.exception.CustomerNotFound;
import com.angelos.e_shop.app.repository.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // dependency injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new CustomerNotFound("Customer with ID " + id + " not found.");
        }
        return customer;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
