package com.angelos.e_shop.app.domain;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
