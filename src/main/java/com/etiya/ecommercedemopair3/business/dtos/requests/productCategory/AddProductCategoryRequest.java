package com.etiya.ecommercedemopair3.business.dtos.requests.productCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductCategoryRequest {
    @Positive
    private int categoryId;
    @Positive
    private int productId;
}
