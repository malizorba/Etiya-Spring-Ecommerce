package com.etiya.ecommercedemopair3.business.dtos.requests.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCategoryRequest {
    private String name;
}