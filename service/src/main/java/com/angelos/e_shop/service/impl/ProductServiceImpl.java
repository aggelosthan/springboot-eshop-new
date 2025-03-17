package com.angelos.e_shop.service.impl;

import com.angelos.e_shop.common.exception.ProductNotFound;
import com.angelos.e_shop.domain.Product;
import com.angelos.e_shop.repository.ProductRepository;
import com.angelos.e_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFound(id);
        }
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFound(id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAvailableProductsInPriceRange(double minPrice, double maxPrice) {
        return productRepository.findAvailableProductsInPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findLowStockProducts(threshold);
    }

    @Override
    public List<Product> searchProductsByNameAndPrice(String searchTerm, double maxPrice) {
        return productRepository.searchProductsByNameAndPrice(searchTerm, maxPrice);
    }

    @Override
    public List<Product> getLowStockProductsInPriceRange(int threshold, double minPrice, double maxPrice) {
        return productRepository.findLowStockProductsInPriceRange(threshold, minPrice, maxPrice);
    }
} 