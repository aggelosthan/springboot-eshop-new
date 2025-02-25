package com.angelos.e_shop.app.dto.product;
import lombok.*;

@Getter
@ToString
public class GetProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private byte rating;
}
