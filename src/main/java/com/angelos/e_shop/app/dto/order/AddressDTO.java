package com.angelos.e_shop.app.dto.order;

import lombok.*;


@Getter
@Setter
@ToString

public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
