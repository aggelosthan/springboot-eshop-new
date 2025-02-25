package com.angelos.e_shop.app.dto.order;
import lombok.*;

import java.util.List;


@Getter
@ToString
@AllArgsConstructor

public class CreateOrderDTO {

    @NonNull
    private Long customerId;

    @NonNull
    private String message;

    @NonNull
    private List<Long> productIds;

    @NonNull
    private AddressDTO shippingAddress;

}
