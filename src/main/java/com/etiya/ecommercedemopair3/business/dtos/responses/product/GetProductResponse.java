package com.etiya.ecommercedemopair3.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProductResponse {
    private String name;
    private int stock;
    private double unitPrice;
}
