package com.etiya.ecommercedemopair3.business.dtos.requests.street;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddStreetRequest {
    private String name;
    private int cityId;
}
