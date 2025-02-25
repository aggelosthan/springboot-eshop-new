package com.angelos.e_shop.app.dto.order;
import com.angelos.e_shop.app.dto.customer.GetCostumerDTO;
import com.angelos.e_shop.app.dto.product.GetProductDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString

public class GetOrderDTO {
    private Long id;
    private GetCostumerDTO customer;
    private String message;
    private List<GetProductDTO> products;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private AddressDTO shippingAddress;

}
