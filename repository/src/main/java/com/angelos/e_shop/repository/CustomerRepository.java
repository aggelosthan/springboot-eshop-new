package com.angelos.e_shop.repository;

import com.angelos.e_shop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // Find customer by email
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Optional<Customer> findByEmail(@Param("email") String email);
    
    // Find customers by name containing (case-insensitive)
    @Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> findByNameContainingIgnoreCase(@Param("name") String name);
    
    // Find customers with orders above a certain amount
    @Query("SELECT DISTINCT c FROM Customer c JOIN c.orders o WHERE o.totalAmount > :amount")
    List<Customer> findCustomersWithOrdersAboveAmount(@Param("amount") double amount);
    
    // Find customers who have placed orders in a specific date range
    @Query("SELECT DISTINCT c FROM Customer c JOIN c.orders o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Customer> findCustomersWithOrdersInDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    @Query("SELECT o FROM Order o WHERE o.customer.email = :email ORDER BY o.orderDate DESC")
    List<Order> findByCustomerEmail(@Param("email") String email);
} 