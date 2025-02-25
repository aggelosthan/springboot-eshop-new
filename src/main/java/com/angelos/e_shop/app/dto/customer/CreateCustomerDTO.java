package com.angelos.e_shop.app.dto.customer;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor

public class CreateCustomerDTO {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String username;

    @NonNull
    private String password;
}
