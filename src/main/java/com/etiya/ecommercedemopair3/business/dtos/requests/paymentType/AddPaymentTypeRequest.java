package com.etiya.ecommercedemopair3.business.dtos.requests.paymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddPaymentTypeRequest {
    private String name;
    private String description;
}