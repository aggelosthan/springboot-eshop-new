package com.angelos.e_shop.repository;

import com.angelos.e_shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Find products by price range with stock check
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice AND p.stockQuantity > 0")
    List<Product> findAvailableProductsInPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
    
    // Find products with low stock (below threshold)
    @Query("SELECT p FROM Product p WHERE p.stockQuantity < :threshold ORDER BY p.stockQuantity ASC")
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
    
    // Search products by name (case-insensitive) with price filter
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) AND p.price <= :maxPrice")
    List<Product> searchProductsByNameAndPrice(@Param("searchTerm") String searchTerm, @Param("maxPrice") double maxPrice);
    
    // Find products that need restocking (stock below threshold) and are in a specific price range
    @Query("SELECT p FROM Product p WHERE p.stockQuantity < :threshold AND p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findLowStockProductsInPriceRange(
            @Param("threshold") int threshold,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice
    );
} 