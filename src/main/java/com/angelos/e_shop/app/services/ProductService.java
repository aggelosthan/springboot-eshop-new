package com.angelos.e_shop.app.services;

import com.angelos.e_shop.app.domain.Product;
import com.angelos.e_shop.app.exception.ProductNotFound;
import com.angelos.e_shop.app.repository.product.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // dependency injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);
        if(product == null) {
            throw new ProductNotFound("Product with ID " + id + " not found.");
        }
        return product;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

}
