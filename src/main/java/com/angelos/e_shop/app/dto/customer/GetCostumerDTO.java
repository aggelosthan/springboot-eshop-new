package com.angelos.e_shop.app.dto.customer;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class GetCostumerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private int bonusPoints;
    private boolean active;
}
