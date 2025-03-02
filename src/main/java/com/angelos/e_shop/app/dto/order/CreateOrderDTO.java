package com.angelos.e_shop.app.dto.order;

import java.util.List;




public class CreateOrderDTO {
    public CreateOrderDTO(Long customerId, String message, List<Long> productIds, AddressDTO shippingAddress) {
        this.customerId = customerId;
        this.message = message;
        this.productIds = productIds;
        this.shippingAddress = shippingAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getMessage() {
        return message;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    private Long customerId;

    private String message;

    private List<Long> productIds;

    private AddressDTO shippingAddress;

}
