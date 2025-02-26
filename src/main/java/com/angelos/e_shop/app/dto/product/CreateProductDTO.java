package com.angelos.e_shop.app.dto.product;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor

public class CreateProductDTO {
    @NonNull
    private String name;

    @NonNull
    private Double price;

    @NonNull
    private String description;
}
