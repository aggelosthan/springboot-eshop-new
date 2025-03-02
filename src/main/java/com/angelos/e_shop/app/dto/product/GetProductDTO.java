package com.angelos.e_shop.app.dto.product;


public class GetProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private byte rating;


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Double getprice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public byte getRating() {
        return rating;
    }
}
