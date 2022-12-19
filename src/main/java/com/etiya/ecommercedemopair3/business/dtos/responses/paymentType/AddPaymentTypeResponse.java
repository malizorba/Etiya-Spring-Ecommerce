package com.etiya.ecommercedemopair3.business.dtos.responses.paymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddPaymentTypeResponse {
    private  int Id;
    private String name;
    private String description;
}
