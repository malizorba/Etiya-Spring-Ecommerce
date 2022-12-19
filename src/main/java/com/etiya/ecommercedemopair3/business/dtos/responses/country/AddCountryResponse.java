package com.etiya.ecommercedemopair3.business.dtos.responses.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryResponse {
    private int id;
    private String name;
}