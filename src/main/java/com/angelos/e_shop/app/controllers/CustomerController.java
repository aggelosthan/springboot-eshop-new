package com.angelos.e_shop.app.controllers;

import com.angelos.e_shop.app.domain.Customer;
import com.angelos.e_shop.app.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Customer created successfully");

    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existing = customerService.getCustomerById(id);
        if (existing == null) {
            return ResponseEntity.ok("Customer not found");
        }
        customer.setId(id);
        customerService.updateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully");

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        Customer existing = customerService.getCustomerById(id);
        if (existing == null) {
            return ResponseEntity.ok("Customer not found");
        }
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
