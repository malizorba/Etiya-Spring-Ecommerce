package com.etiya.ecommercedemopair3.business.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @Min(value = 1)
    private double unitPrice;
    @Min(value = 0)
    private int stock;
}
