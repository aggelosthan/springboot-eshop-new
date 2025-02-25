package com.angelos.e_shop.app.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class Customer {
    private Long id;

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

    private int bonusPoints;
    private boolean active = true;



    // With NonNull we mean that this fields are required, for the @RequiredArgsConstruct to work.
}
