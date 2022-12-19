package com.etiya.ecommercedemopair3.business.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderRequest {
    private int paymentId;
    private int customerId;
    private int addressId;
    private LocalDate orderDate;
    private String orderNumber;
}
