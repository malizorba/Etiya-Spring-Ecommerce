package com.etiya.ecommercedemopair3.business.dtos.responses.customer;

import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddCustomerResponse {
    private  int id;
    private int customerNumber;
}
