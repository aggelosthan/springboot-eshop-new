package com.angelos.e_shop.app.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor

public class Order {
    private Long id;

    @NonNull
    private Customer customer;

    @NonNull
    private String message;

    @NonNull
    private List<Product> products;

    @NonNull
    private LocalDateTime orderDate = LocalDateTime.now();

    @NonNull
    private Address shippingAddress;

}
