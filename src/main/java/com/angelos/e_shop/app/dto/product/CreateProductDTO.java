package com.angelos.e_shop.app.dto.product;


public class CreateProductDTO {
    public String getName() {
        return name;
    }

    public CreateProductDTO(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    private String name;

    private Double price;

    private String description;
}
