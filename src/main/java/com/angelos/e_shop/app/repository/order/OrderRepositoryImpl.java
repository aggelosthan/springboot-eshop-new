package com.angelos.e_shop.app.repository.order;

import com.angelos.e_shop.app.domain.Address;
import com.angelos.e_shop.app.domain.Customer;
import com.angelos.e_shop.app.domain.Order;
import com.angelos.e_shop.app.domain.Product;
import com.angelos.e_shop.app.repository.customer.CustomerRepository;
import com.angelos.e_shop.app.repository.product.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    // In-memory storage for Order objects.
    private final List<Order> orders = new ArrayList<>();


    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderRepositoryImpl(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> orderOpt = orders.stream()
                .filter(order -> order.getId() != null && order.getId().equals(id))
                .findFirst();
        return orderOpt.orElse(null);
    }

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            order.setId((long) (orders.size() + 1));
        }
        orders.add(order);
    }

    @Override
    public void update(Order order) {
        Order existing = findById(order.getId());
        if (existing != null) {
            existing.setCustomer(order.getCustomer());
            existing.setMessage(order.getMessage());
            existing.setProducts(order.getProducts());
            existing.setOrderDate(order.getOrderDate());
            existing.setShippingAddress(order.getShippingAddress());
        }
    }

    @Override
    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId() != null && order.getId().equals(id));
    }

    @PostConstruct
    public void orderData() {

        System.out.println("Prepopulating order data");

        // Retrieve a sample customer
        Customer sampleCustomer = customerRepository.findById(1L);
        if (sampleCustomer == null) {
            System.out.println("No sample customer found. Skipping order prepopulation.");
            return;
        }

        // Retrieve an existing product
        Product sampleProduct = productRepository.findById(1L);
        if (sampleProduct == null) {
            System.out.println("No sample product found. Skipping order prepopulation.");
            return;
        }

        // Create a list of addresses
        List<Address> sampleAddresses = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Address addr = new Address("Street " + i, "City " + i, "State " + i, "Postal" + i, "Country " + i);
            sampleAddresses.add(addr);
        }

        // Create a list for the product
        List<Product> productList = new ArrayList<>();
        productList.add(sampleProduct);

        // Pretty obvious x)
        // not sure if correct, I have to REREREcheck
        for (int i = 1; i <= 10; i++) {
            Address orderAddress = sampleAddresses.get(i - 1);

            Order order = new Order(sampleCustomer, "Order message " + i, productList, LocalDateTime.now(), orderAddress);
            order.setId((long) i);

            save(order);
        }

        System.out.println("Prepopulated 10 orders with 10 sample addresses.");
    }




}
