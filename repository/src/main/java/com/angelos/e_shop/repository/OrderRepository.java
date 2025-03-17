package com.angelos.e_shop.repository;

import com.angelos.e_shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Find orders by customer ID
    @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId ORDER BY o.orderDate DESC")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
    
    // Find orders within a date range
    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate ORDER BY o.orderDate DESC")
    List<Order> findByOrderDateBetween(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
    
    // Find orders with total amount greater than
    @Query("SELECT o FROM Order o WHERE o.totalAmount > :amount ORDER BY o.totalAmount DESC")
    List<Order> findOrdersWithAmountGreaterThan(@Param("amount") double amount);
    
    // Find orders by customer email
    @Query("SELECT o FROM Order o WHERE o.customer.email = :email ORDER BY o.orderDate DESC")
    List<Order> findByCustomerEmail(@Param("email") String email);
    
    // Find orders with specific product
    @Query("SELECT DISTINCT o FROM Order o JOIN o.items i WHERE i.product.id = :productId")
    List<Order> findOrdersContainingProduct(@Param("productId") Long productId);
    
    // Find orders with total amount in range
    @Query("SELECT o FROM Order o WHERE o.totalAmount BETWEEN :minAmount AND :maxAmount ORDER BY o.totalAmount DESC")
    List<Order> findOrdersWithAmountInRange(
            @Param("minAmount") double minAmount,
            @Param("maxAmount") double maxAmount
    );
} 