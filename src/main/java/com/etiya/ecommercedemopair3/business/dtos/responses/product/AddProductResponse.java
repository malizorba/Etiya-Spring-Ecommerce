package com.etiya.ecommercedemopair3.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductResponse {
    private  int productId;
    private String name;
    private double unitPrice;
    private int stock;
}
