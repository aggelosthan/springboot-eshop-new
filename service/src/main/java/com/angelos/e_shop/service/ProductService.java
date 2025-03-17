package com.angelos.e_shop.service;

import com.angelos.e_shop.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAvailableProductsInPriceRange(double minPrice, double maxPrice);
    List<Product> getLowStockProducts(int threshold);
    List<Product> searchProductsByNameAndPrice(String searchTerm, double maxPrice);
    List<Product> getLowStockProductsInPriceRange(int threshold, double minPrice, double maxPrice);
} 