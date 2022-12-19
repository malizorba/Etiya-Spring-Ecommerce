package com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddIndividualCustomerResponse {
    private int Id;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private int customerNumber;
}
