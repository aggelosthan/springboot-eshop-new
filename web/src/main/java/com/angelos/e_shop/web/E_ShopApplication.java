package com.angelos.e_shop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.angelos.e_shop")
@EntityScan("com.angelos.e_shop.domain")
@EnableJpaRepositories("com.angelos.e_shop.repository")
public class E_ShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(E_ShopApplication.class, args);
    }
} 