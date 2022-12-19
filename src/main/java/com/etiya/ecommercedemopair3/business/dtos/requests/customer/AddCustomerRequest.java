package com.etiya.ecommercedemopair3.business.dtos.requests.customer;

import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddCustomerRequest {
    private int customerNumber;
}
