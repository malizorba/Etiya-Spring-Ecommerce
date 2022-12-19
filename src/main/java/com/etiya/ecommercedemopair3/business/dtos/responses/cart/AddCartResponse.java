package com.etiya.ecommercedemopair3.business.dtos.responses.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartResponse {
    private  int id;
    private double totalPrice;
}
