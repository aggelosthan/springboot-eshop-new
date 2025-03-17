package com.angelos.e_shop.web.controller;

import com.angelos.e_shop.domain.Product;
import com.angelos.e_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getAvailableProductsInPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return ResponseEntity.ok(productService.getAvailableProductsInPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/low-stock/{threshold}")
    public ResponseEntity<List<Product>> getLowStockProducts(@PathVariable int threshold) {
        return ResponseEntity.ok(productService.getLowStockProducts(threshold));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByNameAndPrice(
            @RequestParam String searchTerm,
            @RequestParam double maxPrice) {
        return ResponseEntity.ok(productService.searchProductsByNameAndPrice(searchTerm, maxPrice));
    }

    @GetMapping("/low-stock-price-range")
    public ResponseEntity<List<Product>> getLowStockProductsInPriceRange(
            @RequestParam int threshold,
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return ResponseEntity.ok(productService.getLowStockProductsInPriceRange(threshold, minPrice, maxPrice));
    }
} 