package com.angelos.e_shop.app.dto.order;
import com.angelos.e_shop.app.dto.customer.GetCostumerDTO;
import com.angelos.e_shop.app.dto.product.GetProductDTO;

import java.time.LocalDateTime;
import java.util.List;


public class GetOrderDTO {
    private Long id;
    private GetCostumerDTO customer;
    private String message;
    private List<GetProductDTO> products;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private AddressDTO shippingAddress;

    public Long getId() {
        return id;
    }

    public GetCostumerDTO getCustomer() {
        return customer;
    }

    public String getMessage() {
        return message;
    }

    public List<GetProductDTO> getProducts() {
        return products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }
}
