package com.angelos.e_shop.app.domain;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Product {
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Double price;

    @NonNull
    private String description;

    @NonNull
    private byte rating;
}

// With NonNull we mean that this fields are required, for the @RequiredArgsConstruct.
