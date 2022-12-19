package com.etiya.ecommercedemopair3.business.dtos.requests.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartRequest {
    private double totalPrice;

}
