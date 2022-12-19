package com.etiya.ecommercedemopair3.business.dtos.responses.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCityResponse {

    private int id;

    private String name;

    private int countryId;
}
