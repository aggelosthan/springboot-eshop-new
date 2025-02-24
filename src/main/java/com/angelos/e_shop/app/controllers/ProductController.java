package com.angelos.e_shop.app.controllers;

import com.angelos.e_shop.app.domain.Product;
import com.angelos.e_shop.app.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // retrieve all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // retrieve a specific product by ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // creates a new product
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
