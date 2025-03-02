package com.angelos.e_shop.app.repository.product;

import com.angelos.e_shop.app.domain.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    // In-memory storage for Product objects.
    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOpt = products.stream()
                .filter(p -> p.getId() != null && p.getId().equals(id))
                .findFirst();
        return productOpt.orElse(null);
    }

    @Override
    public void save(Product product) {
        // Simulate auto-generation of ID if not provided.
        if (product.getId() == null) {
            product.setId((long) (products.size() + 1));
        }
        products.add(product);
    }

    @Override
    public void update(Product product) {
        Product existing = findById(product.getId());
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setRating(product.getRating());
        }
    }


    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId() != null && product.getId().equals(id));
    }

    @Override
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void productData() {
        System.out.println("Prepopulating product data");
        save(new Product("Asus Vivobook", 800.0, "High-end laptop", (byte) 7));
        save(new Product("Lenovo Gaming Laptop", 1100.0, "High-end gaming laptop", (byte) 8));
        save(new Product("Hp", 650.0, "Mid-end laptop", (byte) 6));
        save(new Product("Samsung S24", 1300.0, "High-end smartphone", (byte) 8));
        save(new Product("Iphone", 1300.0, "High-end smartphone", (byte) 9));
        save(new Product("Samsung Tab s9", 600.0, "Lightweight tablet", (byte) 6));
        System.out.println("Product data Prepopulated successfully.");
    }
}
