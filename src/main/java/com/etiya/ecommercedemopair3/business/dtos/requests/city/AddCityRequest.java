package com.etiya.ecommercedemopair3.business.dtos.requests.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    private String name;
    private int countryId;
}